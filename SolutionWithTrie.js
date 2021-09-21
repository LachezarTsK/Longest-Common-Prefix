

var longestCP;
var root;

/**
 * @param {string[]} strs
 * @return {string}
 */

var longestCommonPrefix = function (strs) {

    longestCP = strs[0];
    root = new TrieNode();
    addFirstWord(strs[0]);

    for (let i = 1; i < strs.length; i++) {
        searchForCommonPrefix(strs[i]);
        if (longestCP === "") {
            break;
        }
    }

    return longestCP;
};

function searchForCommonPrefix(word) {
    let current = root;
    let n = word.length;
    let a = "a".codePointAt(0);
    let prefix;

    for (prefix = 0; prefix < n; prefix++) {
        let ch = word.codePointAt(prefix);
        if (!(current.alphabet[ch - a] instanceof TrieNode)) {
            break;
        }
        current = current.alphabet[ch - a];
    }

    if (longestCP.length > prefix) {
        longestCP = word.substring(0, prefix);
    }
}
function addFirstWord(word) {

    let current = root;
    let n = word.length;
    let a = "a".codePointAt(0);

    for (let i = 0; i < n; i++) {
        let ch = word.codePointAt(i);
        if (!(current.alphabet[ch - a]instanceof TrieNode)) {
            current.alphabet[ch - a] = new TrieNode();
        }
        current = current.alphabet[ch - a];
    }
}

class TrieNode {
    constructor() {
        this.alphabet = [];
    }
}
