import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class PgnReader {
    public static boolean kCastleBlack = true;
    public static boolean qCastleBlack = true;
    public static boolean kCastleWhite = true;
    public static boolean qCastleWhite = true;
    public static int gameLocation;
    public static String theRealGame;
    public static int currentMove = 1;
    public static String[][] board= new String[][]{
        {"r", "n", "b", "q", "k", "b", "n", "r"},
        {"p", "p", "p", "p", "p", "p", "p", "p"},
        {"1", "1", "1", "1", "1", "1", "1", "1"},
        {"1", "1", "1", "1", "1", "1", "1", "1"},
        {"1", "1", "1", "1", "1", "1", "1", "1"},
        {"1", "1", "1", "1", "1", "1", "1", "1"},
        {"P", "P", "P", "P", "P", "P", "P", "P"},
        {"R", "N", "B", "Q", "K", "B", "N", "R"}
    };
    public static String tagValue(String tagName, String game) {
        int index = game.indexOf(tagName);
        int quoteFinder = index + tagName.length() + 2;
        if (index > -1) {
            return game.substring(quoteFinder,game.indexOf('"',quoteFinder));
        }
        return "NOT GIVEN";
    }
    public static void playGame(String game) {
        gameLocation = game.indexOf("1.");
        theRealGame = game.substring(gameLocation);
        theRealGame = theRealGame.replaceAll("\\?","");
        theRealGame = theRealGame.replaceAll("\\+","");
        theRealGame = theRealGame.replaceAll("\\!","");
        theRealGame = theRealGame.replaceAll("\\#","");
        System.out.println(theRealGame);
        gameLocation = 3;
        while(gameLocation<theRealGame.length()) {
            if (theRealGame.charAt(gameLocation) == 'R') {
                RMove();
            }
            else if (theRealGame.charAt(gameLocation) == 'B') {
                BMove();
            }
            else if (theRealGame.charAt(gameLocation) == 'N') {
                NMove();
            }
            else if (theRealGame.charAt(gameLocation) == 'Q') {
                QMove();
            }
            else if (theRealGame.charAt(gameLocation) == 'a'
                    ||theRealGame.charAt(gameLocation) == 'b'
                    ||theRealGame.charAt(gameLocation) == 'c'
                    ||theRealGame.charAt(gameLocation) == 'd'
                    ||theRealGame.charAt(gameLocation) == 'e'
                    ||theRealGame.charAt(gameLocation) == 'f'
                    ||theRealGame.charAt(gameLocation) == 'g'
                    ||theRealGame.charAt(gameLocation) == 'h') {
                PMove();
            }
            else if (theRealGame.charAt(gameLocation) == 'K') {
                KMove();
            }
            else if (theRealGame.charAt(gameLocation) == 'O') {
                Castle();
            }
            gameLocation++;
        }
    }
    public static void NMove() {
        int rank = 0;
        int file = 0;
        int startingRank = -1;
        int startingFile = -1;
        boolean moved = false;
        //Ne7 move 3 more
        //Nxe7 move 4 more
        //Nxe7 move 4 more
        //Naxe7 move 5 more
        if (theRealGame.charAt(gameLocation + 1) == 'x') { //normal capture Nxg7
            switch(theRealGame.charAt(gameLocation + 2)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
            //Ngxd7
        } else if (theRealGame.charAt(gameLocation + 2) == 'x') { //ambiguous cap
                switch(theRealGame.charAt(gameLocation + 1)) { //same file dif rank
                    case '1':   startingRank = 7;
                    break;
                    case '2':   startingRank = 6;
                    break;
                    case '3':   startingRank = 5;
                    break;
                    case '4':   startingRank = 4;
                    break;
                    case '5':   startingRank = 3;
                    break;
                    case '6':   startingRank = 2;
                    break;
                    case '7':   startingRank = 1;
                    break;
                    case '8':   startingRank = 0;
                    break;
                    case 'a':   startingFile = 0;
                    break;
                    case 'b':   startingFile = 1;
                    break;
                    case 'c':   startingFile = 2;
                    break;
                    case 'd':   startingFile = 3;
                    break;
                    case 'e':   startingFile = 4;
                    break;
                    case 'f':   startingFile = 5;
                    break;
                    case 'g':   startingFile = 6;
                    break;
                    case 'h':   startingFile = 7;
                    break;
                }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 4)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        } else if (Character.isDigit(theRealGame.charAt(gameLocation + 3))) { //Nde6 or N7e5 Nxe5 but Nxe5 should be solved earlier
            switch(theRealGame.charAt(gameLocation + 1)) {
                case 'a':   startingFile = 0;
                break;
                case 'b':   startingFile = 1;
                break;
                case 'c':   startingFile = 2;
                break;
                case 'd':   startingFile = 3;
                break;
                case 'e':   startingFile = 4;
                break;
                case 'f':   startingFile = 5;
                break;
                case 'g':   startingFile = 6;
                break;
                case 'h':   startingFile = 7;
                break;
                case '1':   startingRank = 7;
                break;
                case '2':   startingRank = 6;
                break;
                case '3':   startingRank = 5;
                break;
                case '4':   startingRank = 4;
                break;
                case '5':   startingRank = 3;
                break;
                case '6':   startingRank = 2;
                break;
                case '7':   startingRank = 1;
                break;
                case '8':   startingRank = 0;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 2)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        } else { //Ng7
            switch(theRealGame.charAt(gameLocation + 1)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 2)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        }
        if (currentMove%2 == 1) { //whitemove
            int i = 0;
            int j = 0;
            while(moved == false) {
                j = 0;
                while(moved == false && j<8) {
                    if (board[i][j].equals("N")) {
                        if ((Math.abs(rank-i) == 1 && Math.abs(file-j) == 2) ||(Math.abs(rank-i) == 2 && Math.abs(file-j) == 1)) {
                            if (startingRank!=-1 || startingFile !=-1) {
                                if (i == startingRank && startingFile == -1) {
                                    board[i][j] = "1";
                                    board[rank][file] = "N";
                                    moved = true;
                                } else if (j == startingFile && startingRank == -1) {
                                    board[i][j] = "1";
                                    board[rank][file] = "N";
                                    moved = true;
                                }
                            } else {
                                board[i][j]="1";
                                board[rank][file]="N";
                                moved = true;
                            }
                        }
                    }
                    j++;
                }
                i++;
            }
        } else { //blackmore
            int i = 7;
            int j = 7;
            while(moved == false) {
                j = 7;
                while(moved == false && j>-1) {
                    if (board[i][j].equals("n")) {
                        if ((Math.abs(rank-i) == 1 && Math.abs(file-j) == 2) ||(Math.abs(rank-i) == 2 && Math.abs(file-j) == 1)) {
                            if (startingRank!=-1 || startingFile !=-1) {
                                if (i == startingRank && startingFile == -1) {
                                    board[i][j] = "1";
                                    board[rank][file] = "n";
                                    gameLocation += 2;
                                    moved = true;
                                } else if (j == startingFile && startingRank == -1) {
                                    board[i][j] = "1";
                                    board[rank][file] = "n";
                                    gameLocation += 2;
                                    moved = true;
                                }
                            } else if (startingRank == -1 && startingFile  == -1) {
                                board[i][j]="1";
                                board[rank][file]="n";
                                moved = true;
                            }

                            /*if (i == startingRank) {
                                board[i][j] = "1";
                                board[rank][file] = "n";
                                gameLocation += 2;
                                moved = true;
                            } else if (j == startingFile) {
                                board[i][j] = "1";
                                board[rank][file] = "n";
                                gameLocation += 2;
                                moved = true;
                            } else {
                                board[i][j]="1";
                                board[rank][file]="n";
                                moved = true;
                            } */
                        }
                    }
                    j--;
                }
                i--;
            }
            gameLocation += 2;
        }
        currentMove++;
        gameLocation += 3;

    }
    public static void BMove() {
        int rank = 0;
        int file = 0;
        int startingFile = -1;
        int startingRank = -1;
        boolean moved = false;
        boolean blocked = false;
        if (theRealGame.charAt(gameLocation + 1) == 'x') {
            switch(theRealGame.charAt(gameLocation + 2)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }

        } if (theRealGame.charAt(gameLocation + 2) == 'x') { //ambiguous cap
                switch(theRealGame.charAt(gameLocation + 1)) { //same file dif rank
                    case '1':   startingRank = 7;
                    break;
                    case '2':   startingRank = 6;
                    break;
                    case '3':   startingRank = 5;
                    break;
                    case '4':   startingRank = 4;
                    break;
                    case '5':   startingRank = 3;
                    break;
                    case '6':   startingRank = 2;
                    break;
                    case '7':   startingRank = 1;
                    break;
                    case '8':   startingRank = 0;
                    break;
                    case 'a':   startingFile = 0;
                    break;
                    case 'b':   startingFile = 1;
                    break;
                    case 'c':   startingFile = 2;
                    break;
                    case 'd':   startingFile = 3;
                    break;
                    case 'e':   startingFile = 4;
                    break;
                    case 'f':   startingFile = 5;
                    break;
                    case 'g':   startingFile = 6;
                    break;
                    case 'h':   startingFile = 7;
                    break;
                }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 4)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        } else if (Character.isDigit(theRealGame.charAt(gameLocation + 3))) { //Nde6 or N7e5 Nxe5 but Nxe5 should be solved earlier
            switch(theRealGame.charAt(gameLocation + 1)) {
                case 'a':   startingFile = 0;
                break;
                case 'b':   startingFile = 1;
                break;
                case 'c':   startingFile = 2;
                break;
                case 'd':   startingFile = 3;
                break;
                case 'e':   startingFile = 4;
                break;
                case 'f':   startingFile = 5;
                break;
                case 'g':   startingFile = 6;
                break;
                case 'h':   startingFile = 7;
                break;
                case '1':   startingRank = 7;
                break;
                case '2':   startingRank = 6;
                break;
                case '3':   startingRank = 5;
                break;
                case '4':   startingRank = 4;
                break;
                case '5':   startingRank = 3;
                break;
                case '6':   startingRank = 2;
                break;
                case '7':   startingRank = 1;
                break;
                case '8':   startingRank = 0;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 2)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        } else {
            switch(theRealGame.charAt(gameLocation + 1)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 2)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        }
        if (currentMove%2 == 1) { //whitemove
            int i =0;
            while (moved == false) {
                int j = 0;
                while (moved == false && j < 8) {
                    if (board[i][j].equals("B")) {
                        if (Math.abs(rank-i) == Math.abs(file-j)) {
                            blocked = false;
                            if ((rank - i > 0) && (file - j > 0)) {
                                for (int a = i+1, c = j+1; (a<rank) && (c < file); a++, c++) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if ((rank - i > 0) && (file - j < 0)) {
                                for (int a = i+1, c = j-1;(a<rank) && (c > file); a++, c-- ) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if ((rank - i < 0) && (file - j < 0)) {
                                for (int a = i-1, c = j-1;(a>rank) && (c > file); a--, c-- ) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if ((rank - i < 0) && (file - j > 0)) {
                                for (int a = i-1, c = j+1; (a>rank) && (c < file); a--, c++ ) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            }
                            if (!blocked) {
                                if (startingRank!=-1 || startingFile !=-1) {
                                    if (i == startingRank && startingFile == -1) {
                                        board[i][j] = "1";
                                        board[rank][file] = "B";
                                        moved = true;
                                    } else if (j == startingFile && startingRank == -1) {
                                        board[i][j] = "1";
                                        board[rank][file] = "B";
                                        moved = true;
                                    }
                                } else {
                                    board[i][j]="1";
                                    board[rank][file]="B";
                                    moved = true;
                                }
                            }
                        }
                    }
                    j++;
                }
                i++;
            }
        } else { //blackmore
            int i =7;
            while (moved==false) {
                int j = 7;
                while (moved == false && j>-1) {
                    if (board[i][j].equals("b")) {
                        if (Math.abs(rank-i) == Math.abs(file-j)) {
                            blocked = false;
                            if ((rank - i > 0) && (file - j > 0)) {
                                for (int a = i+1, c = j+1; (a<rank) && (c < file); a++, c++) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if ((rank - i > 0) && (file - j < 0)) {
                                for (int a = i+1, c = j-1;(a<rank) && (c > file); a++, c-- ) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if ((rank - i < 0) && (file - j < 0)) {
                                for (int a = i-1, c = j-1;(a>rank) && (c > file); a--, c-- ) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if ((rank - i < 0) && (file - j > 0)) {
                                for (int a = i-1, c = j+1; (a>rank) && (c < file); a--, c++ ) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            }
                            if (!blocked) {
                                if (startingRank!=-1 || startingFile !=-1) {
                                    if (i == startingRank && startingFile == -1) {
                                        board[i][j] = "1";
                                        board[rank][file] = "b";
                                        moved = true;
                                    } else if (j == startingFile && startingRank == -1) {
                                        board[i][j] = "1";
                                        board[rank][file] = "b";
                                        moved = true;
                                    }
                                } else {
                                    board[i][j]="1";
                                    board[rank][file]="b";
                                    moved = true;
                                }
                            }
                        }
                    }
                }
            }
            gameLocation += 2;
        }
        currentMove++;
        gameLocation += 3;

    }
    public static void RMove() {
        int rank = 0;
        int file = 0;
        int startingRank = -1;
        int startingFile = -1;
        boolean moved = false;
        boolean blocked = false;
        if (theRealGame.charAt(gameLocation + 1) == 'x') {
            switch(theRealGame.charAt(gameLocation + 2)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }

        } if (theRealGame.charAt(gameLocation + 2) == 'x') { //ambiguous cap
                switch(theRealGame.charAt(gameLocation + 1)) { //same file dif rank
                    case '1':   startingRank = 7;
                    break;
                    case '2':   startingRank = 6;
                    break;
                    case '3':   startingRank = 5;
                    break;
                    case '4':   startingRank = 4;
                    break;
                    case '5':   startingRank = 3;
                    break;
                    case '6':   startingRank = 2;
                    break;
                    case '7':   startingRank = 1;
                    break;
                    case '8':   startingRank = 0;
                    break;
                    case 'a':   startingFile = 0;
                    break;
                    case 'b':   startingFile = 1;
                    break;
                    case 'c':   startingFile = 2;
                    break;
                    case 'd':   startingFile = 3;
                    break;
                    case 'e':   startingFile = 4;
                    break;
                    case 'f':   startingFile = 5;
                    break;
                    case 'g':   startingFile = 6;
                    break;
                    case 'h':   startingFile = 7;
                    break;
                }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 4)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        } else if (Character.isDigit(theRealGame.charAt(gameLocation + 3))) { //Nde6 or N7e5 Nxe5 but Nxe5 should be solved earlier
            switch(theRealGame.charAt(gameLocation + 1)) {
                case 'a':   startingFile = 0;
                break;
                case 'b':   startingFile = 1;
                break;
                case 'c':   startingFile = 2;
                break;
                case 'd':   startingFile = 3;
                break;
                case 'e':   startingFile = 4;
                break;
                case 'f':   startingFile = 5;
                break;
                case 'g':   startingFile = 6;
                break;
                case 'h':   startingFile = 7;
                break;
                case '1':   startingRank = 7;
                break;
                case '2':   startingRank = 6;
                break;
                case '3':   startingRank = 5;
                break;
                case '4':   startingRank = 4;
                break;
                case '5':   startingRank = 3;
                break;
                case '6':   startingRank = 2;
                break;
                case '7':   startingRank = 1;
                break;
                case '8':   startingRank = 0;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 2)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        } else {
            switch(theRealGame.charAt(gameLocation + 1)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 2)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        }
        if (currentMove%2 == 1) { //whitemove
            int i = 0;
            int j = 0;
            while(moved == false) {
                j = 0;
                while(moved == false && j<8) {
                    blocked = false;
                    if (board[i][j].equals("R")) {
                        if ((Math.abs(rank-i) == 0 && Math.abs(file-j) != 0) || (Math.abs(rank-i)!=0 && Math.abs(file-j) == 0)) {
                            if(rank - i != 0) {
                                if (rank > i) {
                                    for (int a = i + 1;a < rank; a++) {
                                        if (!board[a][j].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                } else {
                                    for (int a = i - 1;a > rank; a-- ) {
                                        if (!board[a][j].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                }
                            } else {
                                if (file > j) {
                                    for (int a = j + 1;a < file; a++) {
                                        if (!board[i][a].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                } else {
                                    for (int a = j - 1;a > file; a--) {
                                        if (!board[i][a].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                }
                            }
                            if (!blocked) {
                                if (startingRank!=-1 || startingFile !=-1) {
                                    if (i == startingRank && startingFile == -1) {
                                        board[i][j] = "1";
                                        board[rank][file] = "R";
                                        moved = true;
                                    } else if (j == startingFile && startingRank == -1) {
                                        board[i][j] = "1";
                                        board[rank][file] = "R";
                                        moved = true;
                                    }
                                } else {
                                    board[i][j]="1";
                                    board[rank][file]="R";
                                    moved = true;
                                }
                            }
                        }
                    }
                    j++;
                }
                i++;
            }
        } else { //blackmore
            int i = 7;
            int j = 7;
            while(moved == false) {
                j = 7;
                while(moved == false && j>-1) {
                    if (board[i][j].equals("r")) {
                        blocked = false;
                        if ((Math.abs(rank-i) == 0 && Math.abs(file-j) != 0) ||(Math.abs(rank-i)!=0 && Math.abs(file-j) == 0)) {
                            if(rank - i != 0) {
                                if (rank > i) { //vertically down
                                    for (int a = i + 1;a < rank; a++) {
                                        if (!board[a][j].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                } else { //vertically up
                                    for (int a = i - 1;a > rank; a-- ) {
                                        if (!board[a][j].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                }
                            } else {
                                if (file > j) {
                                    for (int a = j + 1;a < file; a++) {
                                        if (!board[i][a].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                } else {
                                    for (int a = j - 1;a > file; a--) {
                                        if (!board[i][a].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                }
                            }
                            if (!blocked) {
                                if (startingRank!=-1 || startingFile !=-1) {
                                    if (i == startingRank && startingFile == -1) {
                                        board[i][j] = "1";
                                        board[rank][file] = "r";
                                        moved = true;
                                    } else if (j == startingFile && startingRank == -1) {
                                        board[i][j] = "1";
                                        board[rank][file] = "r";
                                        moved = true;
                                    }
                                } else {
                                    board[i][j]="1";
                                    board[rank][file]="r";
                                    moved = true;
                                }
                            }
                        }
                    }
                    j--;
                }
                i--;
            }
            gameLocation += 2;
        }
        currentMove++;
        gameLocation += 3;
    }
    public static void QMove() {
        int rank = 0;
        int needstobeadded = 0;
        int file = 0;
        int startingRank = -1;
        int startingFile = -1;
        boolean moved = false;
        boolean blocked = false;
        if (theRealGame.charAt(gameLocation + 1) == 'x') { //Qxe4
            needstobeadded = 4;
            switch(theRealGame.charAt(gameLocation + 2)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        } else if (theRealGame.charAt(gameLocation + 2) == 'x') { //ambiguous cap Qfxe4
            needstobeadded = 5;
            switch(theRealGame.charAt(gameLocation + 1)) { //same file dif rank
                    case '1':   startingRank = 7;
                    break;
                    case '2':   startingRank = 6;
                    break;
                    case '3':   startingRank = 5;
                    break;
                    case '4':   startingRank = 4;
                    break;
                    case '5':   startingRank = 3;
                    break;
                    case '6':   startingRank = 2;
                    break;
                    case '7':   startingRank = 1;
                    break;
                    case '8':   startingRank = 0;
                    break;
                    case 'a':   startingFile = 0;
                    break;
                    case 'b':   startingFile = 1;
                    break;
                    case 'c':   startingFile = 2;
                    break;
                    case 'd':   startingFile = 3;
                    break;
                    case 'e':   startingFile = 4;
                    break;
                    case 'f':   startingFile = 5;
                    break;
                    case 'g':   startingFile = 6;
                    break;
                    case 'h':   startingFile = 7;
                    break;
                }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 4)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        } else if (theRealGame.charAt(gameLocation + 3) == 'x') {
            //Qe4xd5
            needstobeadded = 6;
            switch(theRealGame.charAt(gameLocation + 1)) { //e
                    case 'a':   startingFile = 0;
                    break;
                    case 'b':   startingFile = 1;
                    break;
                    case 'c':   startingFile = 2;
                    break;
                    case 'd':   startingFile = 3;
                    break;
                    case 'e':   startingFile = 4;
                    break;
                    case 'f':   startingFile = 5;
                    break;
                    case 'g':   startingFile = 6;
                    break;
                    case 'h':   startingFile = 7;
                    break;
                }
            switch(theRealGame.charAt(gameLocation + 2)) { //4
                    case '1':   startingRank = 7;
                    break;
                    case '2':   startingRank = 6;
                    break;
                    case '3':   startingRank = 5;
                    break;
                    case '4':   startingRank = 4;
                    break;
                    case '5':   startingRank = 3;
                    break;
                    case '6':   startingRank = 2;
                    break;
                    case '7':   startingRank = 1;
                    break;
                    case '8':   startingRank = 0;
                    break;
            }
            switch(theRealGame.charAt(gameLocation + 4)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 5)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        } else if (Character.isDigit(theRealGame.charAt(gameLocation + 3))) { //Nde6 or N7e5 Nxe5 but Nxe5 should be solved earlier
            needstobeadded = 4;
            switch(theRealGame.charAt(gameLocation + 1)) {
                case 'a':   startingFile = 0;
                break;
                case 'b':   startingFile = 1;
                break;
                case 'c':   startingFile = 2;
                break;
                case 'd':   startingFile = 3;
                break;
                case 'e':   startingFile = 4;
                break;
                case 'f':   startingFile = 5;
                break;
                case 'g':   startingFile = 6;
                break;
                case 'h':   startingFile = 7;
                break;
                case '1':   startingRank = 7;
                break;
                case '2':   startingRank = 6;
                break;
                case '3':   startingRank = 5;
                break;
                case '4':   startingRank = 4;
                break;
                case '5':   startingRank = 3;
                break;
                case '6':   startingRank = 2;
                break;
                case '7':   startingRank = 1;
                break;
                case '8':   startingRank = 0;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 2)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        } else if (Character.isDigit(theRealGame.charAt(gameLocation + 4))) {
            //Qe4d5
            needstobeadded = 5;
               switch(theRealGame.charAt(gameLocation + 1)) {
                   case 'a':   startingFile = 0;
                   break;
                   case 'b':   startingFile = 1;
                   break;
                   case 'c':   startingFile = 2;
                   break;
                   case 'd':   startingFile = 3;
                   break;
                   case 'e':   startingFile = 4;
                   break;
                   case 'f':   startingFile = 5;
                   break;
                   case 'g':   startingFile = 6;
                   break;
                   case 'h':   startingFile = 7;
                   break;
               }
               switch(theRealGame.charAt(gameLocation + 2)) {
                   case '1':   startingRank = 7;
                   break;
                   case '2':   startingRank = 6;
                   break;
                   case '3':   startingRank = 5;
                   break;
                   case '4':   startingRank = 4;
                   break;
                   case '5':   startingRank = 3;
                   break;
                   case '6':   startingRank = 2;
                   break;
                   case '7':   startingRank = 1;
                   break;
                   case '8':   startingRank = 0;
                   break;
               }
               switch(theRealGame.charAt(gameLocation + 3)) {
                   case 'a':   file = 0;
                   break;
                   case 'b':   file = 1;
                   break;
                   case 'c':   file = 2;
                   break;
                   case 'd':   file = 3;
                   break;
                   case 'e':   file = 4;
                   break;
                   case 'f':   file = 5;
                   break;
                   case 'g':   file = 6;
                   break;
                   case 'h':   file = 7;
                   break;
               }
               switch(theRealGame.charAt(gameLocation + 4)) {
                   case '1':   rank = 7;
                   break;
                   case '2':   rank = 6;
                   break;
                   case '3':   rank = 5;
                   break;
                   case '4':   rank = 4;
                   break;
                   case '5':   rank = 3;
                   break;
                   case '6':   rank = 2;
                   break;
                   case '7':   rank = 1;
                   break;
                   case '8':   rank = 0;
                   break;
               }
        } else {
            needstobeadded = 3;
            switch(theRealGame.charAt(gameLocation + 1)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 2)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        }
        if (currentMove%2 == 1) { //whitemove
            int i = 0;
            while (!moved) {
                int j = 0;
                while(!moved && j<7) {
                    if (board[i][j].equals("Q")) {
                        if (((Math.abs(rank-i) == 0 && Math.abs(file-j) != 0) || (Math.abs(rank-i)!=0 && Math.abs(file-j) == 0)) || (Math.abs(rank-i) == Math.abs(file-j))) {
                        blocked = false;
                            if ((rank - i > 0) && (file - j > 0)) {
                                for (int a = i+1, c = j+1; (a<rank) && (c < file); a++, c++) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if ((rank - i > 0) && (file - j < 0)) {
                                for (int a = i+1, c = j-1;(a<rank) && (c > file); a++, c-- ) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if ((rank - i < 0) && (file - j < 0)) {
                                for (int a = i-1, c = j-1;(a>rank) && (c > file); a--, c-- ) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if ((rank - i < 0) && (file - j > 0)) {
                                for (int a = i-1, c = j+1; (a>rank) && (c < file); a--, c++ ) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if(rank - i != 0 && file-i==0) {
                                if (rank > i) {
                                    for (int a = i + 1;a < rank; a++) {
                                        if (!board[a][j].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                } else {
                                    for (int a = i - 1;a > rank; a-- ) {
                                        if (!board[a][j].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                }
                            } else if (rank - i == 0 && file - i != 0) {
                                if (file > j) {
                                    for (int a = j + 1;a < file; a++) {
                                        if (!board[i][a].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                } else {
                                    for (int a = j - 1;a > file; a--) {
                                        if (!board[i][a].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                }
                            }
                            System.out.println(blocked);
                        if (!blocked) {
                            if (startingRank != -1 && startingFile != -1) {
                                if (i == startingRank && j == startingFile) {
                                    board[i][j] = "1";
                                    board[rank][file] = "Q";
                                    moved = true;
                                }
                            } else if (startingRank!=-1 || startingFile !=-1) {
                                if (i == startingRank && startingFile == -1) {
                                    board[i][j] = "1";
                                    board[rank][file] = "Q";
                                    moved = true;
                                } else if (j == startingFile && startingRank == -1) {
                                    board[i][j] = "1";
                                    board[rank][file] = "Q";
                                    moved = true;
                                }
                            } else {
                                board[i][j]="1";
                                board[rank][file]="Q";
                                moved = true;
                            }
                        }
                    }
                    }
                    j++;
                }
                i++;
            }
        } else { //blackmore
            int i =7;
            while(!moved){
                int j = 7;
                while(!moved && j>-1) {
                    if (board[i][j].equals("q")) {
                        if (((Math.abs(rank-i) == 0 && Math.abs(file-j) != 0) || (Math.abs(rank-i)!=0 && Math.abs(file-j) == 0)) || (Math.abs(rank-i) == Math.abs(file-j))) {
                        blocked = false;
                            if ((rank - i > 0) && (file - j > 0)) {
                                for (int a = i+1, c = j+1; (a<rank) && (c < file); a++, c++) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if ((rank - i > 0) && (file - j < 0)) {
                                for (int a = i+1, c = j-1;(a<rank) && (c > file); a++, c-- ) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if ((rank - i < 0) && (file - j < 0)) {
                                for (int a = i-1, c = j-1;(a>rank) && (c > file); a--, c-- ) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if ((rank - i < 0) && (file - j > 0)) {
                                for (int a = i-1, c = j+1; (a>rank) && (c < file); a--, c++ ) {
                                    if (!board[a][c].equals("1")) {
                                        blocked = true;
                                    }
                                }
                            } else if(rank - i != 0 && file-i==0) {
                                if (rank > i) {
                                    for (int a = i + 1;a < rank; a++) {
                                        if (!board[a][j].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                } else {
                                    for (int a = i - 1;a > rank; a-- ) {
                                        if (!board[a][j].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                }
                            } else if (rank - i == 0 && file - i != 0) {
                                if (file > j) {
                                    for (int a = j + 1;a < file; a++) {
                                        if (!board[i][a].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                } else {
                                    for (int a = j - 1;a > file; a--) {
                                        if (!board[i][a].equals("1")) {
                                            blocked = true;
                                        }
                                    }
                                }
                            }
                            System.out.println(blocked);
                        if (!blocked) {
                            if (startingRank!=-1 || startingFile !=-1) {
                                if (i == startingRank && startingFile == -1) {
                                    board[i][j] = "1";
                                    board[rank][file] = "q";
                                    moved = true;
                                } else if (j == startingFile && startingRank == -1) {
                                    board[i][j] = "1";
                                    board[rank][file] = "q";
                                    moved = true;
                                }
                            } else {
                                board[i][j]="1";
                                board[rank][file]="q";
                                moved = true;
                            }
                        }
                    }
                    }
                    j--;
                }
                i--;
            }
            gameLocation += 2;
        }
        currentMove++;
        gameLocation += needstobeadded;
    }
    public static void PMove() {
        int rank = 0;
        int file = 0;
        boolean moved = false;
        int destinationFile = 0;
        switch(theRealGame.charAt(gameLocation)) { //where horizontally
            case 'a':   file = 0;
            break;
            case 'b':   file = 1;
            break;
            case 'c':   file = 2;
            break;
            case 'd':   file = 3;
            break;
            case 'e':   file = 4;
            break;
            case 'f':   file = 5;
            break;
            case 'g':   file = 6;
            break;
            case 'h':   file = 7;
            break;
        }
        if (theRealGame.charAt(gameLocation + 1) == 'x') { //if capture
            switch(theRealGame.charAt(gameLocation + 2)) {
                case 'a':   destinationFile = 0;
                break;
                case 'b':   destinationFile = 1;
                break;
                case 'c':   destinationFile = 2;
                break;
                case 'd':   destinationFile = 3;
                break;
                case 'e':   destinationFile = 4;
                break;
                case 'f':   destinationFile = 5;
                break;
                case 'g':   destinationFile = 6;
                break;
                case 'h':   destinationFile = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
            if (currentMove%2 == 1) { //whitecapture
                for (int i = 0;i<8 ; i++ ) {
                    if (board[i][file].equals("P") && rank<i) {
                        board[i][file]="1";
                        board[rank][destinationFile]="P";
                        if (rank == 0) {
                            switch(theRealGame.charAt(gameLocation + 5)) {
                                case 'Q':   board[rank][destinationFile]="Q";
                                break;
                                case 'N':   board[rank][destinationFile]="N";
                                break;
                                case 'B':   board[rank][destinationFile]="B";
                                break;
                                case 'R':   board[rank][destinationFile]="R";
                                break;
                            }
                            gameLocation += 2;
                        }
                        if (rank == 2 && board[rank + 1][destinationFile].equals("p")) {
                            board[rank + 1][destinationFile]="1";
                        }
                        currentMove++;
                        break;
                    }
                }
            } else {
                for (int i = 7;i>-1 ; i--) { //black move
                    if (board[i][file].equals("p") && rank>i) {
                        board[i][file]="1";
                        board[rank][destinationFile]="p";
                        if (rank == 7) {
                            switch(theRealGame.charAt(gameLocation + 5)) {
                                case 'Q':   board[rank][destinationFile]="q";
                                break;
                                case 'N':   board[rank][destinationFile]="n";
                                break;
                                case 'B':   board[rank][destinationFile]="b";
                                break;
                                case 'R':   board[rank][destinationFile]="r";
                                break;
                            }
                            gameLocation += 2;
                        }
                        if (rank == 5 && board[rank-1][destinationFile].equals("P")) {
                            board[rank-1][destinationFile]="1";
                        }
                        currentMove++;
                        gameLocation += 1;
                        break;
                    }
                }
            }
            gameLocation += 1;
        } else {
            switch(theRealGame.charAt(gameLocation + 1)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
            if (currentMove%2 == 1) { //whitemove
                for (int i = 0;i<8 ; i++ ) {
                    if (board[i][file].equals("P") && rank<i) {
                        board[i][file]="1";
                        board[rank][file]="P";
                        if (rank == 0) {
                            switch(theRealGame.charAt(gameLocation + 3)) {
                                case 'Q':   board[rank][file]="Q";
                                break;
                                case 'N':   board[rank][file]="N";
                                break;
                                case 'B':   board[rank][file]="B";
                                break;
                                case 'R':   board[rank][file]="R";
                                break;
                            }
                            gameLocation += 2;
                        }
                        currentMove++;
                        break;
                    }
                }
            } else {
                for (int i = 7;i>-1 ; i--) { //black move
                    if (board[i][file].equals("p") && rank>i) {
                        board[i][file]="1";
                        board[rank][file]="p";
                        if (rank == 7) {
                            switch(theRealGame.charAt(gameLocation + 3)) {
                                case 'Q':   board[rank][file]="q";
                                break;
                                case 'N':   board[rank][file]="n";
                                break;
                                case 'B':   board[rank][file]="b";
                                break;
                                case 'R':   board[rank][file]="r";
                                break;
                            }
                            gameLocation += 2;
                        }
                        currentMove++;
                        gameLocation += 1;
                        break;
                    }
                }
            }
        }
        gameLocation += 2;

    }
    public static void KMove() {
        int rank = 0;
        int file = 0;
        if (theRealGame.charAt(gameLocation + 1) == 'x') {
            switch(theRealGame.charAt(gameLocation + 2)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 3)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }

        } else{
            switch(theRealGame.charAt(gameLocation + 1)) {
                case 'a':   file = 0;
                break;
                case 'b':   file = 1;
                break;
                case 'c':   file = 2;
                break;
                case 'd':   file = 3;
                break;
                case 'e':   file = 4;
                break;
                case 'f':   file = 5;
                break;
                case 'g':   file = 6;
                break;
                case 'h':   file = 7;
                break;
            }
            switch(theRealGame.charAt(gameLocation + 2)) {
                case '1':   rank = 7;
                break;
                case '2':   rank = 6;
                break;
                case '3':   rank = 5;
                break;
                case '4':   rank = 4;
                break;
                case '5':   rank = 3;
                break;
                case '6':   rank = 2;
                break;
                case '7':   rank = 1;
                break;
                case '8':   rank = 0;
                break;
            }
        }
        if (currentMove%2 == 1) { //whitemove
            for (int i = 0;i < 8 ; i++ ) {
                for (int j = 0; j < 8 ; j++ ) {
                    if (board[i][j].equals("K")) {
                        board[i][j]="1";
                        board[rank][file]="K";
                        break;
                    }
                }
            }
        } else { //blackmore
            for (int i = 7;i >- 1; i--) {
                for (int j = 7; j >- 1; j--) {
                    if (board[i][j].equals("k")) {
                        board[i][j]="1";
                        board[rank][file]="k";
                        break;
                    }
                }
            }
            gameLocation += 2;
        }
        currentMove++;
        gameLocation += 3;
    }
    public static void Castle() {
        if (currentMove%2 == 1) { //whitemove
            if (theRealGame.charAt(gameLocation + 3) == '-') { //O-O-O
                board[7][2] = "K";
                board[7][3] = "R";
                board[7][0] = "1";
                board[7][4] = "1";
                gameLocation += 2;
            } else {
                board[7][6] = "K";
                board[7][5] = "R";
                board[7][7] = "1";
                board[7][4] = "1";
            }
        } else { //blackmove
            if (theRealGame.charAt(gameLocation + 3) == '-') { //O-O-O
                board[0][2] = "k";
                board[0][3] = "r";
                board[0][0] = "1";
                board[0][4] = "1";
                gameLocation += 2;
            } else {
                board[0][6] = "k";
                board[0][5] = "r";
                board[0][7] = "1";
                board[0][4] = "1";
            }
        }
        currentMove++;
        gameLocation += 3;
    }
    public static String finalPosition(String game) {
        String finalGameState = "";
        int sum = 0;
        for (int r = 0; r<board.length;r++ ) {
            for (int c = 0; c<board[r].length; c++) {
                //finalGameState = finalGameState + board[r][c];
                if (board[r][c].equals("1")) {
                    sum++;
                } else{
                    if (sum>0 && sum<7) {
                        finalGameState = finalGameState + sum + board[r][c];
                        sum = 0;
                    } else {
                        finalGameState = finalGameState + board[r][c];
                    }
                }
                if (sum == 8) {
                    finalGameState = finalGameState + sum;
                    sum = 0;
                }
            }
            if (sum!=0) {
                finalGameState = finalGameState + sum;
                sum = 0;
            }

            if (r == board.length-1) {
                return finalGameState;
            } else {
                finalGameState = finalGameState+"/";
            }
        }
        return finalGameState;

    }

    public static String fileContent(String path) {
        Path file = Paths.get(path);
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = Files.newBufferedReader(file)) {
            String line = null;
            while((line = reader.readLine()) != null) {
                // Add the \n that's removed by readline()
                sb.append(line + "\n");
            }
        } catch(IOException e) {
            System.err.format("IOException: %s%n", e);
            System.exit(1);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String game = fileContent(args[0]);
        System.out.println("Event: " + tagValue("Event", game));
        System.out.println("Site: " + tagValue("Site", game));
        System.out.println("Date: " + tagValue("Date", game));
        System.out.format("Round: %s%n", tagValue("Round", game));
        System.out.format("White: %s%n", tagValue("White", game));
        System.out.format("Black: %s%n", tagValue("Black", game));
        System.out.format("Result: %s%n", tagValue("Result", game));
        System.out.println("Final Position:");
        playGame(game);
        System.out.println(finalPosition(game));
    }
}
