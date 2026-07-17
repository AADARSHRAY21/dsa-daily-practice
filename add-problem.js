#!/usr/bin/env node
/**
 * add-problem.js
 *
 * One command to:
 *  1. Ask you a few questions about the problem you just solved
 *  2. Create the file in the correct topic folder with a notes template
 *  3. Open it in Notepad so you paste your solution code
 *  4. Wait for you to confirm you're done editing
 *  5. Auto-update the README progress table
 *  6. Auto git add + commit + push
 *
 * Usage:
 *   node add-problem.js
 *
 * Run this from inside your dsa-daily-practice folder.
 */

const fs = require("fs");
const path = require("path");
const readline = require("readline");
const { execSync, spawn } = require("child_process");

const TOPICS = [
  "arrays",
  "strings",
  "linked-lists",
  "stacks-queues",
  "trees",
  "graphs",
  "Sorting",
  "dp",
  "greedy",
  "binary-search",
  "heaps",
  "backtracking",
  "two-pointers-sliding-window",
];

const PROGRESS_FILE = path.join(__dirname, "progress.json");
const README_FILE = path.join(__dirname, "README.md");
const START_MARKER = "<!-- STATS_START -->";
const END_MARKER = "<!-- STATS_END -->";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function ask(question) {
  return new Promise((resolve) => rl.question(question, (answer) => resolve(answer.trim())));
}

function toKebabCase(str) {
  return str
    .toLowerCase()
    .replace(/[^a-z0-9]+/g, "-")
    .replace(/(^-|-$)/g, "");
}

function loadProgress() {
  if (!fs.existsSync(PROGRESS_FILE)) return [];
  return JSON.parse(fs.readFileSync(PROGRESS_FILE, "utf8"));
}

function saveProgress(entries) {
  fs.writeFileSync(PROGRESS_FILE, JSON.stringify(entries, null, 2));
}

function getEntryTopics(e) {
  // Supports both new multi-topic entries (topics: [...]) and old single-topic entries (topic: "...")
  if (Array.isArray(e.topics)) return e.topics;
  if (e.topic) return [e.topic];
  return [];
}

function regenerateReadmeStats(entries) {
  let readme = fs.readFileSync(README_FILE, "utf8");
  const startIdx = readme.indexOf(START_MARKER);
  const endIdx = readme.indexOf(END_MARKER);

  if (startIdx === -1 || endIdx === -1) {
    console.log(
      "⚠️  Could not find stats markers in README.md. Skipping auto-update — add markers manually (see SETUP.md)."
    );
    return;
  }

  const counts = {};
  for (const t of TOPICS) counts[t] = 0;
  for (const e of entries) {
    for (const t of getEntryTopics(e)) {
      counts[t] = (counts[t] || 0) + 1;
    }
  }

  const header = "## Stats\n\n| Topic | Solved |\n|-------|--------|\n";
  const rows = TOPICS.filter((t) => counts[t] > 0)
    .map((t) => `| ${t} | ${counts[t]} |`)
    .join("\n");

  // Total counts each solved PROBLEM once, even if it was filed under multiple topics
  const total = entries.length;
  const statsBlock = `${START_MARKER}\n${header}${rows}\n\n**Total problems solved:** ${total}\n${END_MARKER}`;

  readme = readme.slice(0, startIdx) + statsBlock + readme.slice(endIdx + END_MARKER.length);
  fs.writeFileSync(README_FILE, readme);
}

function openInNotepad(filePath) {
  const child = spawn("notepad.exe", [filePath], { detached: true, stdio: "ignore" });
  child.unref();
}

async function main() {
  console.log("\n📌 New solved problem — let's log it.\n");

  console.log("Pick topic folder(s) — comma-separated if the problem spans multiple (e.g. 1,3):");
  TOPICS.forEach((t, i) => console.log(`  ${i + 1}. ${t}`));
  let topics = [];
  while (topics.length === 0) {
    const answer = await ask(`Enter number(s) (1-${TOPICS.length}): `);
    const indices = answer
      .split(",")
      .map((s) => parseInt(s.trim(), 10) - 1)
      .filter((i) => !isNaN(i) && i >= 0 && i < TOPICS.length);
    // dedupe while preserving order
    const seen = new Set();
    topics = indices.filter((i) => {
      if (seen.has(i)) return false;
      seen.add(i);
      return true;
    }).map((i) => TOPICS[i]);
    if (topics.length === 0) {
      console.log(`Please enter valid number(s) between 1 and ${TOPICS.length}, comma-separated.`);
    }
  }
  console.log(`Selected: ${topics.join(", ")}`);

  const problemName = await ask("Problem name (e.g. Valid Anagram): ");
  const leetcodeNum = await ask("LeetCode number (optional, press Enter to skip): ");
  const link = await ask("Problem link (paste URL): ");
  const difficulty = await ask("Difficulty (Easy/Medium/Hard): ");
  const pattern = await ask("Pattern (e.g. Sliding Window, DFS, DP - Knapsack): ");
  const Timecomplexity = await ask("Time Complexity");
  const Spacecomplexity = await ask("Space Complextiy");
  const notes = await ask("notes:");
  const neededHint = await ask("Needed a hint? (Yes/No): ");

  const fileName = `${toKebabCase(problemName)}.java`;
  const filePaths = topics.map((t) => path.join(__dirname, t, fileName));

  const alreadyExists = filePaths.find((p) => fs.existsSync(p));
  if (alreadyExists) {
    console.log(`\n⚠️  ${alreadyExists} already exists. Aborting so nothing gets overwritten.`);
    rl.close();
    return;
  }

  const today = new Date().toISOString().split("T")[0];

  const template = `/*
 * Problem: ${problemName}${leetcodeNum ? ` (LeetCode #${leetcodeNum})` : ""}
 * Link: ${link}
 * Difficulty: ${difficulty}
 * Pattern: ${pattern}
 * Topics: ${topics.join(", ")}
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: ${timeComplexity}
 * Space Complexity: ${spaceComplexity}
 *
 * Needed hint? ${neededHint}
 * Notes : ${notes}
 * Revisit on: (7 days from ${today})
 */

// TODO: paste your solved code below

`;

  // Write the template to the first selected topic folder — this is the one you'll edit in Notepad
  const primaryFilePath = filePaths[0];
  fs.writeFileSync(primaryFilePath, template);
  console.log(`\n✅ Created ${topics[0]}/${fileName}`);
  console.log("📝 Opening it in Notepad — paste your code, save, and close it (or leave it open).");

  openInNotepad(primaryFilePath);

  await ask("\nPress Enter here once you've saved your code in Notepad... ");

  // Copy the finished file into every other selected topic folder
  const finalContent = fs.readFileSync(primaryFilePath, "utf8");
  for (let i = 1; i < filePaths.length; i++) {
    fs.writeFileSync(filePaths[i], finalContent);
    console.log(`✅ Copied into ${topics[i]}/${fileName}`);
  }

  const entries = loadProgress();
  entries.push({
    date: today,
    problem: problemName,
    topics,
    difficulty,
    pattern,
    link,
    "Time Complexity":TimeComplexity,
    "Space Comp[lexity":Spacecomplexity,
    notes,
  });
  saveProgress(entries);
  regenerateReadmeStats(entries);
  console.log("✅ README stats updated.");

  try {
    execSync("git add .", { cwd: __dirname, stdio: "inherit" });
    execSync(
      `git commit -m "Day ${entries.length}: Solved - ${problemName} (${pattern})"`,
      { cwd: __dirname, stdio: "inherit" }
    );
    execSync("git push", { cwd: __dirname, stdio: "inherit" });
    console.log("\n🚀 Pushed to GitHub successfully!");
  } catch (err) {
    console.log("\n⚠️  Git commit/push failed. You may need to run 'git add . && git commit -m \"...\" && git push' manually.");
    console.log("Error detail:", err.message);
  }

  rl.close();
}

main();
