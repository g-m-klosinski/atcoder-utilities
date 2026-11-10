# AtCoder Utilities

A command line tool to fetch test vectors from an AtCoder contest task

## Usage

Run the application with task coordinates, for example:

```bash
./gradlew run --args="abc 400 b"
```

It will store test vectors in a directory under system-default
temporary directory, for example:

```
/tmp
├── atcoder-abc400_b000000123
│   ├── 1.in
│   ├── 1.out
│   ├── 2.in
│   ├── 2.out
│   ├── 3.in
│   ├── 3.out
│   ├── 4.in
│   └── 4.out
```

Client software may assume the prefix to be `atcoder-abc400_b`.