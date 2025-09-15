Algorithms in TypeScript

This folder contains a minimal TypeScript setup with a first failing test to bootstrap TDD.

Prerequisites
- Node.js 18+ (or 20+ recommended)

Install dependencies
- From this folder, run: npm install

Run tests
- One-off run: npm test
- Watch mode: npm run test:watch

Running from WebStorm / IDE
- Make sure the IDE is configured to use Node.js 18 or newer for this project. Vitest v2 requires Node >= 18. Using an older system Node (e.g., /usr/bin/node at 16.x) may cause Vitest to crash before running tests.
- In WebStorm, go to Settings/Preferences > Languages & Frameworks > Node.js and choose a Node interpreter >= 18 (e.g., the one from nvm). Then re-run the tests.

Current failing test
- tests/sum.test.ts expects sum(1, 2) to equal 3.
- src/sum.ts has an intentional bug so the test fails initially.

Fixing the test
- Implement sum to return a + b and re-run tests to see it pass.

Algorithms in TypeScript

This folder contains a minimal TypeScript setup with a first failing test to bootstrap TDD.

Prerequisites
- Node.js 18+ (or 20+ recommended)

Install dependencies
- From this folder, run: npm install

Run tests
- One-off run: npm test
- Watch mode: npm run test:watch

Running from WebStorm / IDE
- Make sure the IDE is configured to use Node.js 18 or newer for this project. Vitest v2 requires Node >= 18. Using an older system Node (e.g., /usr/bin/node at 16.x) may cause Vitest to crash before running tests.
- In WebStorm, go to Settings/Preferences > Languages & Frameworks > Node.js and choose a Node interpreter >= 18 (e.g., the one from nvm). Then re-run the tests.

Current failing test
- tests/sum.test.ts expects sum(1, 2) to equal 3.
- src/sum.ts has an intentional bug so the test fails initially.

Fixing the test
- Implement sum to return a + b and re-run tests to see it pass.

BinaryGap complexity note
- The BinaryGap implementation converts an integer N to a binary string and scans it once.
- Let L be the length of N’s binary representation (L ≈ floor(log2 N) + 1 for N > 0).
- Building the string is O(L) time and O(L) space; the scan is a single pass O(L).
- Therefore, time complexity is O(L) = O(log N) with respect to the numeric value N. There is no input array; we iterate over the bits of N’s binary form, so it’s not O(N) over an array.
