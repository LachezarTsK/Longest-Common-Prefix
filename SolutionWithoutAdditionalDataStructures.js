
/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {

    var longestCP = strs[0];
    var n = strs.length;

    for (let i = 1; i < n; i++) {

        let index = 0;
        let n_01 = longestCP.length;
        let n_02 = strs[i].length;

        while (index < n_01 && index < n_02) {
            if (longestCP.charAt(index) !== strs[i].charAt(index)) {
                break;
            }
            index++;
        }

        if (index < n_01) {
            longestCP = longestCP.substring(0, index);
            if (index === 0) {
                break;
            }
        }
    }
    return longestCP;
};
