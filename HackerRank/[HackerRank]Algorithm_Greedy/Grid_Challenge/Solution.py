def sort_grid(grid):
    for f1 in range(len(grid)):
        grid[f1] = sorted(grid[f1])
        if f1 > 0:
            for f2 in range(len(grid[f1])):
                if grid[f1][f2] < grid[f1 - 1][f2]:
                    return "NO"
    return "YES"


if __name__ == "__main__":
    numOfTestCase = int(input().strip())
    for f0 in range(numOfTestCase):
        numOfLine = int(input().strip())
        grid = []
        for f1 in range(numOfLine):
            grid.append(input().strip())
        print(sort_grid(grid))
