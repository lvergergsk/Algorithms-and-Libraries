'use strict';

const DEV_MODE = false;

function processData(input) {
    var lines = input.split('\n');
    if (DEV_MODE) console.log('Size of lines =', lines.length);
    for (var l = 1; l < lines.length; l++) {
        nextLexicographicalPermutation(lines[l]);
    }
}

function nextLexicographicalPermutation(str) {
    for (var i = str.length - 1; i > 0; i--) {
        if (DEV_MODE) console.log(str.charAt(i), '>', str.charAt(i - 1), ': ', str.charAt(i) > str.charAt(i - 1));
        if (str.charAt(i) > str.charAt(i - 1)) {
            const pivot = i - 1;
            if (DEV_MODE) console.log('Pivot = ', pivot);
            for (var j = str.length - 1; j > pivot; j--) {
                if (str.charAt(j) > str.charAt(pivot)) {
                    if (DEV_MODE) console.log('Secondary pivot = ', j);
                    const strBehindPivotAfterSwap = str.substr(pivot + 1, j - (pivot + 1))
                        + str.charAt(pivot)
                        + str.substr(j + 1, str.length - (j + 1));
                    if (DEV_MODE) console.log('strBehindPivotAfterSwap: ', strBehindPivotAfterSwap);
                    const rep = str.substr(0, pivot)
                        + str.charAt(j)
                        + reverseString(strBehindPivotAfterSwap);
                    console.log(rep);
                    return;
                }
            }
        }
    }
    console.log('no answer');
}

function reverseString(str) {
    var splitString = str.split('');
    var reverseArray = splitString.reverse();
    return reverseArray.join('');
}

processData('5\nabclkjsnbe\nlatruhbla\naklrhg\naerhgs\nalrehghl');