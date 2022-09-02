package com.game;

class TitlePage {
    static String art =   "██ ▄█▀▓█████▓██   ██▓     █████   █    ██ ▓█████   ██████ ▄▄▄█████▓\n" +
                          "██▄█▒ ▓█   ▀ ▒██  ██▒   ▒██▓  ██▒ ██  ▓██▒▓█   ▀ ▒██    ▒ ▓  ██▒ ▓▒\n" +
                          "▓███▄░ ▒███    ▒██ ██░   ▒██▒  ██░▓██  ▒██░▒███   ░ ▓██▄   ▒ ▓██░ ▒░\n" +
                          "▓██ █▄ ▒▓█  ▄  ░ ▐██▓░   ░██  █▀ ░▓▓█  ░██░▒▓█  ▄   ▒   ██▒░ ▓██▓ ░ \n" +
                          "▒██▒ █▄░▒████▒ ░ ██▒▓░   ░▒███▒█▄ ▒▒█████▓ ░▒████▒▒██████▒▒  ▒██▒ ░ \n" +
                          "▒ ▒▒ ▓▒░░ ▒░ ░  ██▒▒▒    ░░ ▒▒░ ▒ ░▒▓▒ ▒ ▒ ░░ ▒░ ░▒ ▒▓▒ ▒ ░  ▒ ░░   \n" +
                          "░ ░▒ ▒░ ░ ░  ░▓██ ░▒░     ░ ▒░  ░ ░░▒░ ░ ░  ░ ░  ░░ ░▒  ░ ░    ░    \n" +
                          "░ ░░ ░    ░   ▒ ▒ ░░        ░   ░  ░░░ ░ ░    ░   ░  ░  ░    ░      \n" +
                          "░  ░      ░  ░░ ░            ░       ░        ░  ░      ░           \n" +
                          "              ░ ░                                                   ";

    public static void title() throws InterruptedException {
        for (int i = 0; i < art.length(); i++){
            System.out.print(art.charAt(i));
//            Thread.sleep(2);
        }
        System.out.println("\nWelcome to Key Quest!");
    }
}