#!/usr/bin/env node
/**
 * update-stats.js
 *
 * Standalone helper — re-syncs the README Stats section from whatever
 * is currently saved in progress.json, without adding a new problem.
 *
 * Use this any time you manually edit progress.json (e.g. fixing a typo,
 * correcting a topic) and want the README numbers to match again.
 *
 * Usage:
 *   node update-stats.js
 */

const fs = require("fs");
const path = require("path");
const { execSync } = require("child_process");

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
const START_MARKER = "<!-- STATS_START -->";
const END_MARKER = "<!-- STATS_END -->";

function getEntryTopics(e) {
  if (Array.isArray(e.topics)) return e.topics;
  if (e.topic) return [e.topic];
  return [];
}

function main() {
  if (!fs.existsSync(PROGRESS_FILE)) {
    console.log("⚠️  No progress.json found. Nothing to sync.");
    return;
  }

  const entries = JSON.parse(fs.readFileSync(PROGRESS_FILE, "utf8"));

  let readme = fs.readFileSync(README_FILE, "utf8");
  const startIdx = readme.indexOf(START_MARKER);
  const endIdx = readme.indexOf(END_MARKER);

  if (startIdx === -1 || endIdx === -1) {
    console.log("⚠️  Could not find stats markers in README.md. Nothing to update.");
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

  const total = entries.length;
  const statsBlock = `${START_MARKER}\n${header}${rows}\n\n**Total problems solved:** ${total}\n${END_MARKER}`;

  readme = readme.slice(0, startIdx) + statsBlock + readme.slice(endIdx + END_MARKER.length);
  fs.writeFileSync(README_FILE, readme);

  console.log("✅ README stats resynced from progress.json:");
  TOPICS.filter((t) => counts[t] > 0).forEach((t) => console.log(`   ${t}: ${counts[t]}`));
  console.log(`   Total: ${total}`);

  try {
    execSync("git add .", { cwd: __dirname, stdio: "inherit" });
    execSync(`git commit -m "Resync README stats from progress.json"`, {
      cwd: __dirname,
      stdio: "inherit",
    });
    execSync("git push", { cwd: __dirname, stdio: "inherit" });
    console.log("\n🚀 Pushed to GitHub successfully!");
  } catch (err) {
    console.log(
      "\n⚠️  Git commit/push failed (this is normal if there was nothing new to commit)."
    );
    console.log("Detail:", err.message.split("\n")[0]);
  }
}

main();
