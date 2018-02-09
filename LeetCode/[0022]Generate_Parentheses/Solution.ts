/**
 * @param {number} n
 * @return {string[]}
 */
let generateParenthesis = function (n: number) {
    let ans: string[] = [];
    backtrack(ans, "", 0, 0, n);
    return ans;
};

let backtrack = function (ans: string[], cur: string, open: number, close: number, max: number) {
    if (cur.length == max * 2) {
        ans.push(cur);
        return;
    }

    // There are only two things we can do: add "(" or add ")"
    // We can add "(" when the number of open is less than given N,
    // there is nothing else which can stop us doing this.
    // We can add ")" when there is at least one unclosed open parenthesis before,
    // i.e.,  number of close parens. There is nothing else which can stop us doing this.
    if (open < max)
        backtrack(ans, cur + "(", open + 1, close, max);
    if (close < open)
        backtrack(ans, cur + ")", open, close + 1, max);
};

console.log(generateParenthesis(2));