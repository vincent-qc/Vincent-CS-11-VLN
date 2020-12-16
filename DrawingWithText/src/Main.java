public class Main {
    public static void main(String[] args) {
        String bk = "\u001b[30m"; // Black
        String bu = "\u001b[34;1m"; // Blue
        String r = "\u001b[0m"; // Reset
        String rd = "\u001b[31m"; // Red

        // Prints out a image in the form a String
        System.out.println("\u0003                                               " +
                "\n" + "                                    /\\" +
                "\n" + "                                   /" + bu + "c" + r + "\\\\" +
                "\n" + "                                  ‘" + bu + "ch" + r + ".\\\\" +
                "\n" + "                                _/`’ <\\" + bu + "c" + r + ";" +
                "\n" + "      \\%-.__                    \\   ,  \\" + bu + "c" + r + "\\" +
                "\n" + "       \\\\" + bu + "hc" + r + "`:=--._              /  _\\  ." + bu + "hc" + r + "|" +
                "\n" + "        \\ `h" + bu + "hcccccc" + r + "``~-._.^_.--`-~` <    \\" + bu + "c" + r + "\\" +
                "\n" + "        <\\   `.h" + bu + "cccccccccccccchhhhhhh" + r + "^`.  |" + bu + "ccc" + r + "\\" +
                "\n" + "          / ^." + r + "   `h" + bu + "hccccccccccccccccccccc" + r + "./" + bu + "hcc" + r + "|\\" +
                "\n" + "          `~\\~__/`" + bu + "hhhcccccccccccccccccccccccc" + r + "`\\" +
                "\n" + "             |" + bu + "hhcc" + r + "/" + bu + "ccccc cccc" + r + "|" + bu + "hc" + r + "/|" + bu +"hc" + r + "\\" + bu + "hccc" + r + "\\" + bu + "hcc" + r + "\\" + bu + "hc" + r + "|" +
                "\n" + "             /" + bu + "hhhccc" + r + "/\\" + bu + "hhhhhcc" + r + "|" + bu + "c" + r + "/ \\" + bu + "hcc" + r + "|" + bu + "cccc" + r + "|" + bu + "ccc" + r + "\\" + bu + "hc" + r +"\\" +
                "\n" + "            |" + bu + "hhccc" + r + "|/ |" + bu + "hhhhhh"+ r + "/|" + bu + "c" + r + "|  \\" + bu + "hc" + r + "|" + bu + "cccc" + r + "|" + bu + "cccc" + r + "\\" + bu + "c" + r +"|" +
                "\n" + "            /" + bu + "hhhcc" + r + "|   \\" + bu + "hhhhh" + r + "!" + bu + "%" + r + "/    \\" + bu + "h" + r + "|" + bu + "cccc" + r + "|" + bu + "ccccc" + r +"`=-._" +
                "\n" + "          ./" + bu + "hhhhhh" + r + "|    \\" + bu + "hhc" + r + "/|/     \\/" + bu + "cccc" + r +"/" + bu + "ccccchhhh" + r +"/" +
                "\n" + "          |" + bu + "c" + r + "/" + bu + "hccc" + r + "%      `\\" + bu + "c" + r + "//        \\" + bu + "ccccccchh" + r + "`~=^`" +
                "\n" + "           /" + bu + "hhcc" + r + "|| |! !|  ``   |!  ! /" + bu + "cccccccchhhh" + r + "|\\" +
                "\n" + "         _/" + bu + "hhhhc" + r + "|\\  `^^’       \\::;/ |" + bu + "cccc" + r + "|\\" + bu + "hhhhhh" + r + "|" + bu + "c" + r + "%/" +
                "\n" + "        \\" + bu + "hhccccc" + r + "|" + bu + "h" + r + "\\       W          |" + bu + "cccc" + r + "|" + bu + "hhhcccc" + r + "\\=`" +
                "\n" + "         `-|" + bu + "cccc" + r + "|" + bu + "h" + r + "|`-..___________..~/" + bu + "cccc" + r + "|" + bu + "hhccccccc" + r + "|;" +
                "\n" + "           |" + bu + "cccc" + r + "|" + bu + "h" + r + "| \\" + bu + "hhccc" + r + "\\" + bk + "#######" + r + "/" + bu + "h" + r + "/" + bu + "hhccc" + r + "|" + bu + "hhhhccc" + r + "`\\" +
                "\n" + "           \\" + bu + "hccc" + r + "\\" + bu + "hc" + r + "\\ \\" + bu + "hhhc" + r + "/" + bk + "#######" + r + "`-/" + bu + "ccccc" + r + "/" + bu + "hhhhhhhh" + r + "/   /\\" +
                "\n" + "            \\" + bu + "hccc" + r + "\\`=` \\.`" + bk + "##########" + r + "/" + bu + "ccccc" + r + "/|" + bu + "hhhhhh" + r + "\\    /" + bu + "cc" + r + "\\" +
                "\n" + "             \\\\;;/     `\\_/`" + rd + "VVVV" + r + "/\\/_..-’` `\\_/`’   .*`" + bu + "cch" + r + "|" +
                "\n" + "                        \\\\  \\" + rd + "VV" + r + "/   //\\_          _-/" + bu + "cccchh" + r + "/" +
                "\n" + "                        ||  |" + rd + "V" + r + "/   // /`-_  __.-`" + bu + "cccccchh" + r + "/" +
                "\n" + "                        ||  \\/   //    /  \\" + bu + "ccccchhh" + r + "_.=`" +
                "\n" + "                      .-\\\\_.‘.__||  ’=.__/``-\\%%;-’`" +
                "\n" + "                      \\vvv/`\\vvv/_/     ,_  \\" +
                "\n" + "                        \\____-’    \\__-’  `-’"
        );

        /* The Printed Image (without color)
        *
        *                                    /\
        *                                   /c\\
        *                                  ‘ch.\\
        *                                _/`’ <\c;
        *      \%-.__                    \   ,  \c\
        *       \\hc`:=--._              /  _\  .hc|
        *        \ `hhcccccc``~-._.^_.--`-~` <    \c\
        *        <\   `.hcccccccccccccchhhhhhh^`.  |ccc\
        *          / ^.   `hhccccccccccccccccccccc./hcc|\
        *          `~\~__/`hhhcccccccccccccccccccccccc`\
        *             |hhcc/ccccc cccc|hc/|hc\hccc\hcc\hc|
        *             /hhhccc/\hhhhhcc|c/ \hcc|cccc|ccc\hc\
        *            |hhccc|/ |hhhhhh/|c|  \hc|cccc|cccc\c|
        *            /hhhcc|   \hhhhh!%/    \h|cccc|ccccc`=-._
        *          ./hhhhhh|    \hhc/|/     \/cccc/ccccchhhh/
        *          |c/hccc%      `\c//        \ccccccchh`~=^`
        *           /hhcc|| |! !|  ``   |!  ! /cccccccchhhh|\
        *         _/hhhhc|\  `^^’       \::;/ |cccc|\hhhhhh|c%/
        *        \hhccccc|h\       W          |cccc|hhhcccc\=`
        *         `-|cccc|h|`-..___________..~/cccc|hhccccccc|;
        *           |cccc|h| \hhccc\#######/h/hhccc|hhhhccc`\
        *           \hccc\hc\ \hhhc/#######`-/ccccc/hhhhhhhh/   /\
        *            \hccc\`=` \.`##########/ccccc/|hhhhhh\    /cc\
        *             \\;;/     `\_/`VVVV/\/_..-’` `\_/`’   .*`cch|
        *                        \\  \VV/   //\_          _-/cccchh/
        *                        ||  |V/   // /`-_  __.-`cccccchh/
        *                        ||  \/   //    /  \ccccchhh_.=`
        *                      .-\\_.‘.__||  ’=.__/``-\%%;-’`
        *                      \vvv/`\vvv/_/     ,_  \
        *                        \____-’    \__-’  `-’
        *
        */
    }
}
