/**
 * @param {string} s
 * @return {boolean}
 */

let isValid = function (s) {
    let stack = [];
    const charArray = s.split('');
    for (let c of charArray) {
        if (c === '(') {
            stack.push(')')
        } else if (c === '{') {
            stack.push('}')
        } else if (c === '[') {
            stack.push(']')
        } else if (stack.length === 0 || stack.pop() !== c) {
            return false
        }
    }
    return stack.length === 0;
};
