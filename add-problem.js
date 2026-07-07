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
  "dp",
  "greedy",
  "binary-search",
  "heaps",
  "backtracking",
  "two-pointers-sliding-window",
];

const PROGRESS_FILE = path.join(__dirname, "progress.json");
const README_FILE = path.join(__dirname, "README.md");
const START_MARKER = "<!-- PROGRESS_TABLE_START -->";
const END_MARKER = "<!-- PROGRESS_TABLE_END -->";

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

function regenerateReadmeTable(entries) {
  let readme = fs.readFileSync(README_FILE, "utf8");
  const startIdx = readme.indexOf(START_MARKER);
  const endIdx = readme.indexOf(END_MARKER);

  if (startIdx === -1 || endIdx === -1) {
    console.log(
      "⚠️  Could not find table markers in README.md. Skipping auto-update — add markers manually (see SETUP.md)."
    );
    return;
  }

  const header =
    "| Day | Date | Problem | Topic | Difficulty | Pattern | Link | Notes |\n" +
    "|-----|------|---------|-------|------------|---------|------|-------|\n";

  const rows = entries
    .map(
      (e, i) =>
        `| ${i + 1} | ${e.date} | ${e.problem} | ${e.topic} | ${e.difficulty} | ${e.pattern} | [link](${e.link}) | ${e.notes || "-"} |`
    )
    .join("\n");

  const tableBlock = `${START_MARKER}\n${header}${rows}\n${END_MARKER}`;

  readme = readme.slice(0, startIdx) + tableBlock + readme.slice(endIdx + END_MARKER.length);
  fs.writeFileSync(README_FILE, readme);
}

function openInNotepad(filePath) {
  const child = spawn("notepad.exe", [filePath], { detached: true, stdio: "ignore" });
  child.unref();
}

async function main() {
  console.log("\n📌 New solved problem — let's log it.\n");

  console.log("Pick a topic folder:");
  TOPICS.forEach((t, i) => console.log(`  ${i + 1}. ${t}`));
  let topicIdx = -1;
  while (topicIdx < 0 || topicIdx >= TOPICS.length) {
    const answer = await ask(`Enter number (1-${TOPICS.length}): `);
    topicIdx = parseInt(answer, 10) - 1;
  }
  const topic = TOPICS[topicIdx];

  const problemName = await ask("Problem name (e.g. Valid Anagram): ");
  const leetcodeNum = await ask("LeetCode number (optional, press Enter to skip): ");
  const link = await ask("Problem link (paste URL): ");
  const difficulty = await ask("Difficulty (Easy/Medium/Hard): ");
  const pattern = await ask("Pattern (e.g. Sliding Window, DFS, DP - Knapsack): ");
  const neededHint = await ask("Needed a hint? (Yes/No): ");
  const notes = await ask("Any short note for the table (optional): ");

  const fileName = `${toKebabCase(problemName)}.java`;
  const filePath = path.join(__dirname, topic, fileName);

  if (fs.existsSync(filePath)) {
    console.log(`\n⚠️  ${filePath} already exists. Aborting so nothing gets overwritten.`);
    rl.close();
    return;
  }

  const today = new Date().toISOString().split("T")[0];

  const template = `/*
 * Problem: ${problemName}${leetcodeNum ? ` (LeetCode #${leetcodeNum})` : ""}
 * Link: ${link}
 * Difficulty: ${difficulty}
 * Pattern: ${pattern}
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 *
 * Needed hint? ${neededHint}
 *
 * Revisit on: (7 days from ${today})
 */

// TODO: paste your solved code below

`;

  fs.writeFileSync(filePath, template);
  console.log(`\n✅ Created ${topic}/${fileName}`);
  console.log("📝 Opening it in Notepad — paste your code, save, and close it (or leave it open).");

  openInNotepad(filePath);

  await ask("\nPress Enter here once you've saved your code in Notepad... ");

  const entries = loadProgress();
  entries.push({
    date: today,
    problem: problemName,
    topic,
    difficulty,
    pattern,
    link,
    notes,
  });
  saveProgress(entries);
  regenerateReadmeTable(entries);
  console.log("✅ README progress table updated.");

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
