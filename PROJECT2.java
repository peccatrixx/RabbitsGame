import java.util.Scanner;

public class PROJECT2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************************************************************");
        System.out.println("Welcome to “ RABBITS IN THE WOODS” \nTo win this game you will try to find heaven or collect most points. \nIf you come across a rat you will loose some carrots, \nthere will be some carrots on the even numbered locations, \nso try to collect carrots by answering the arithmetic questions, \nyou can gain game points by feeding the carrots to the rabbits.\nThere will also be an escape card from hell, \nif you fall into hell after you find it you will be reborn\nGOOD LUCK... (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
        System.out.println("*******************************************************************");
        System.out.println("Enter the size of the game area: ");
        int S =0;
        while (true){
            S = sc.nextInt();
            if (S<4){
                System.out.println("(╬ Ò﹏Ó)\nI said min 4 ,Please enter again: ");
            }else break;
        }

        //carrots(S);
        int randomhellx,randomhelly,randomheavenx,randomheaveny,randomrabbit2x,randomrabbit2y,randomrabbit3x,randomrabbit3y,randomrat1x,randomrat1y,randomrat2x,randomrat2y,randomplayerx,randomplayery,escapex,escapey;
        int carrotAmount =0;
        int carrotslost =0;
        int carrotcount =0;
        int gamepointslost =0;
        int gamepointswon =0;
        int rabbitcounter =0;
        int ratcounter =0;
        int totalgamepoints =0;
        int escapecard =0;

        String rabbit2,rabbit1,rabbit3,rat1,rat2,player,hell,heaven,escapeFromHell;
        String newplayerlocation = "";


        int randomrabbit1x = randomx(S);
        int randomrabbit1y = randomy(randomrabbit1x);
        rabbit1 = "("+ randomrabbit1x + "," + randomrabbit1y + ") ";

        do {//THESE LOOPS ASSURE US THAT RATS,RABBITS AND THE PLAYER CAN'T BE SPAWNED AT THE SAME LOCATION
            randomrabbit2x = randomx(S);
            randomrabbit2y = randomy(randomrabbit2x);
            rabbit2 = "("+ randomrabbit2x + "," + randomrabbit2y + ") ";
        }while (rabbit1.equals(rabbit2));

        do {
            randomrabbit3x = randomx(S);
            randomrabbit3y = randomy(randomrabbit3x);
            rabbit3 = "("+ randomrabbit3x + "," + randomrabbit3y + ") ";
        }while (rabbit1.equals(rabbit3)||rabbit2.equals(rabbit3));


        do {
            randomrat1x = randomx(S);
            randomrat1y = randomy(randomrat1x);
            rat1 = "("+ randomrat1x + "," + randomrat1y + ") ";
        }while (rat1.equals(rabbit1)||rat1.equals(rabbit2)||rat1.equals(rabbit3));

        do {
            randomrat2x = randomx(S);
            randomrat2y = randomy(randomrat2x);
            rat2 = "("+ randomrat2x + "," + randomrat2y + ") ";
        }while (rat2.equals(rabbit1)||rat2.equals(rabbit2)||rat2.equals(rabbit3)||rat1.equals(rat2));

        do {
            randomplayerx = randomx(S);
            randomplayery = randomy(randomplayerx);
            player = "("+ randomplayerx + "," + randomplayery + ") ";
            newplayerlocation = player;
        }while (player.equals(rabbit1)||player.equals(rabbit2)||player.equals(rabbit3)||player.equals(rat2)||player.equals(rat1));


        do {
            randomhellx = randomx(S);
            randomhelly = randomy(randomhellx);
            hell = "("+ randomhellx + "," + randomhelly + ") ";
        }while (hell.equals(rabbit1)||hell.equals(rabbit2)||hell.equals(rabbit3)||hell.equals(rat2)||hell.equals(rat1)||hell.equals(player));


        do {
            randomheavenx = randomx(S);
            randomheaveny = randomy(randomheavenx);
            heaven = "("+ randomheavenx+ "," + randomheaveny + ") ";
        }while (heaven.equals(rabbit1)||heaven.equals(rabbit2)||heaven.equals(rabbit3)||heaven.equals(rat2)||heaven.equals(rat1)||heaven.equals(player)||heaven.equals(hell));

        do {
            escapex = randomx(S);
            escapey = randomy(escapex);
            escapeFromHell = "("+ escapex+ "," + escapey + ") ";
        }while (escapeFromHell.equals(rabbit1)||escapeFromHell.equals(rabbit2)||escapeFromHell.equals(rabbit3)||escapeFromHell.equals(rat2)||escapeFromHell.equals(rat1)||escapeFromHell.equals(player)||escapeFromHell.equals(hell));


        //WHILE LOOP WILL START FROM HERE
        while (true){


            System.out.println("---------------------------------------------------------------------------------");
            area(S,randomplayerx,randomplayery);
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println(" Player at " + newplayerlocation) ;
            System.out.println("---------------------------------------------------------------------------------");

            int answer = movement();
            System.out.println(answer);

            if (answer==8){
                if (canMove(answer,randomplayerx,randomplayery,S)){
                    System.out.println("invalid movement please choose again!!");
                }else{
                    randomplayerx= movingx(randomplayerx,randomplayery,answer);
                    randomplayery=movingy(randomplayerx,randomplayery,answer);
                }

            }

            if (answer==2){
                if (canMove(answer,randomplayerx,randomplayery,S)){
                    System.out.println("invalid movement please choose again");
                }else{
                    randomplayerx= movingx(randomplayerx,randomplayery,answer);
                    randomplayery=movingy(randomplayerx,randomplayery,answer);
                }
            }


            if (answer==6){
                if (canMove(answer,randomplayerx,randomplayery,S)){
                    System.out.println("invalid movement please choose again");
                }else{
                    randomplayery=movingy(randomplayerx,randomplayery,answer);
                }
            }

            if (answer==4){
                if (canMove(answer,randomplayerx,randomplayery,S)){
                    System.out.println("invalid movement please choose again");
                }else{
                    randomplayery=movingy(randomplayerx,randomplayery,answer);
                }
            }

            newplayerlocation = "("+ randomplayerx + "," + randomplayery + ") ";

            boolean escapecardcheck = escapecard(newplayerlocation,escapeFromHell);
            if (escapecardcheck&&escapecard==0){
                System.out.println("YOU FOUND AN ESCAPE CARD FROM HELL...");
                escapecard =1;

            }


            boolean exittohell = exitToHell(newplayerlocation,hell);
            if (exittohell){
                if (escapecard==1){
                    System.out.println("You have entered hell but since you have an escape card you will be reborn in another location");
                    do {
                        randomplayerx = randomx(S);
                        randomplayery = randomy(randomplayerx);
                        player = "("+ randomplayerx + "," + randomplayery + ") ";
                        newplayerlocation = player;
                    }while (player.equals(rabbit1)||player.equals(rabbit2)||player.equals(rabbit3)||player.equals(rat2)||player.equals(rat1)||player.equals(heaven)||player.equals(hell));
                    escapecard =2;
                }else {
                    System.out.println("HELLLLLL (╥﹏╥), YOU LOST!!!, You lost all of your carrots... and unfortunately you don't own an escape card... ");
                    carrotAmount = 0;
                    break;
                }

            }


            boolean exittoheaven =exitToHeaven(newplayerlocation,heaven);
            if (exittoheaven){
                System.out.println("HEAVENN ᕙ(`▿´)ᕗ, YOU WON!!!");
                break;
            }


            boolean carrotCheck= isThereACarrot(randomplayerx,randomplayery);
            if (carrotCheck&&!canMove(answer,randomplayerx,randomplayery,S)){
                boolean answerofQuestion = generateAquestion();
                if (answerofQuestion){
                    carrotcount = randomcarrots();
                    System.out.println("You have won random amount of carrots, carrots won: " + carrotcount);
                    carrotAmount += carrotcount;
                }else {
                    System.out.println("ಥ_ಥ WRONG, NO CARROTS FOR YOU");
                }

            }



            boolean rabbitcheck =isThereaRabbit(rabbit1,rabbit2,rabbit3,newplayerlocation);
            if (rabbitcheck&&!canMove(answer,randomplayerx,randomplayery,S)){
                rabbitcounter++;
                System.out.println("YOU CAME ACROSS A RABBIT ૮꒰˶• ༝ •˶꒱ა , YOU WILL FEED IT CARROTS TO GAIN GAME POINTS");
                int wantedcarrots = randomcarrots();
                System.out.println("This rabbit wants " + wantedcarrots + " carrots");
                if (wantedcarrots>carrotAmount){
                    System.out.println("You don't have enough carrots, you will loose some game points");
                    gamepointslost = (int)(Math.random()*totalgamepoints+1);
                    System.out.println("game points lost = " + gamepointslost);
                    totalgamepoints = totalgamepoints-gamepointslost;
                }else {
                    carrotAmount = carrotAmount-wantedcarrots;
                    System.out.println("you have enough amount of carrots, you fed "+ wantedcarrots+ "to the rabbit, you have " + carrotAmount + " carrots left");
                    gamepointswon = wantedcarrots*10;
                    System.out.println("you won " + gamepointswon + " game points");
                    totalgamepoints += gamepointswon;
                }

            }



            boolean ratcheck =isThereaRat(rat1,rat2,newplayerlocation);
            if (ratcheck&&!canMove(answer,randomplayerx,randomplayery,S)){
                ratcounter++;
                carrotslost = randomcarrots();
                System.out.println("YOU CAME ACROSS A RAT …ᘛ⁐̤ᕐᐷ, IT WILL STEAL SOME OF YOUR CARROTS ");
                if (carrotAmount==0){
                    System.out.println("THE RAT COULDN'T FIND ANY CARROTS TO STEAL, BECAUSE YOU DON'T HAVE ANY");
                    System.out.println("TOTAL POINTS: " + totalgamepoints);
                    System.out.println("TOTAL CARROTS: " + carrotAmount);
                }else if (carrotslost>carrotAmount){
                    System.out.println("RAT STOLE ALL OF YOUR CARROTS");
                    carrotAmount = 0;

                }else{

                    System.out.println("you have lost " + carrotslost + " carrots");
                    carrotAmount = carrotAmount-carrotslost;
                }

            }
            if (!canMove(answer,randomplayerx,randomplayery,S)){
                System.out.println("-----------------------------------------------------------");
                System.out.println("CARROT AMOUNT: " + carrotAmount);
                System.out.println("GAME POINTS: " + totalgamepoints);
                System.out.println("Rabbit count that you have come across: " + rabbitcounter );
                System.out.println("Rat count that you have come across: " + ratcounter);
                System.out.println("-----------------------------------------------------------");
            }


        }
        System.out.println("---------------------------------------------------------------");
        area(S,randomplayerx,randomplayery);
        System.out.println("---------------------------------------------------------------");
        System.out.println("CARROT AMOUNT: " + carrotAmount);
        System.out.println("GAME POINTS: " + totalgamepoints);
        System.out.println("Rabbit count that you have come across: " + rabbitcounter );
        System.out.println("Rat count that you have come across: " + ratcounter);
        System.out.println("Rabbits were at: " + rabbit1+ "," + rabbit2 + "," + rabbit3 );
        System.out.println("Rats were at: " + rat1 + "," + rat2);
        System.out.println("Heaven was at: " + heaven);
        System.out.println("Hell was at: " + hell);

        CarrotLocations(S);
        System.out.println("");
        System.out.println("---------------------------------------------------------------");

    }

    public static int movement(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your move: ");
        System.out.println(" ");
        System.out.println("            8: UP");
        System.out.println("               ⥣ ");
        System.out.println("   4: LEFT  ⥢    ⥤ 6: RIGHT");
        System.out.println("               ⇓ ");
        System.out.println("            2: DOWN");


        return sc.nextInt();
    }



    public static int movingx(int x,int y, int answer){
        if (answer==8){
            x--;
        }else {
            x++;
        }
        return x;
    }

    public static int movingy(int x,int y, int answer){
         if (answer==8||answer==4){
             y--;
         } else if (answer==2||answer==6) {
             y++;

         }
         return y;
    }

    public static int randomx(int S){
        int RX = (int)(Math.random()*S+1);
        return RX;
    }
    public static int randomy(int S){
        int RY = (int)(Math.random()*(2*S-1)+1);
        return RY;
    }

    public static void area(int S, int playerx,int playery){
        int i =0;
        int j = 0;
        int areacounter =0;
        String placement = "";



        for (i = 1; i <=S; i++) {
            for (int k = 2*(S-i); k > 0; k--) {
                System.out.print("   ");
            }
            for (j = 1; j < (2*i)-1; j++) {
                if (i==playerx&&j==playery){
                    System.out.print("*"+i+","+j+"* ");
                }else{
                    System.out.print("("+i+","+j+") ");
                }

            }

            if (i==playerx&&j==playery){
                System.out.println("*"+i+","+j+"* ");
            }else{
                System.out.println("("+i+","+j+") ");
            }

            placement = "("+i+","+j+") ";
        }

    }

    public static boolean generateAquestion(){
        Scanner sc = new Scanner(System.in);
        boolean result = false;
        System.out.println("Answer the question to get the carrot");
        double answer = 0;
        int random = (int)(Math.random()*4);
        double x = (int)(Math.random()*10+1);
        double y = (int)(Math.random()*10+1);
        switch (random){
            case 0:
                System.out.println(x + " + " + y +" = ?");
                answer = sc.nextInt();
                if (answer== x + y){
                    result = true;
                    System.out.println("(っ◔◡◔)っ ❤ CORRECT");
                }

                break;
            case 1:
                System.out.println(x + " - " + y + "= ?");
                answer = sc.nextInt();
                if (answer == x -y ){
                    result = true;
                    System.out.println("(っ◔◡◔)っ ❤ CORRECT");
                }
                break;
            case 2:
                do {
                    x = (int)(Math.random()*10+1);
                    y = (int)(Math.random()*10+1);
                }while (x%y!=0);
                System.out.println(x + " / " + y + " = ?");
                answer = sc.nextInt();
                if (answer== x/y){
                    result = true;
                    System.out.println("(っ◔◡◔)っ ❤ CORRECT");
                }

                break;
            case 3:
                System.out.println("multiplication");
                System.out.println(x + " * " + y + " = ?" );
                answer = sc.nextInt();
                if (answer== x*y){
                    result = true;
                    System.out.println("(っ◔◡◔)っ ❤ CORRECT");
                }
                break;
            default:
                System.out.println("Wrong answer");

        }
            return result;
    }

    public static int randomcarrots(){
        int carrots = (int)(Math.random()*10+1);
        return carrots;
    }

    public static boolean isThereACarrot(int randompalyerx,int randomplayery){
        boolean areThereCarrots = false;
        if (((randompalyerx % 2) == 0) && ((randomplayery % 2) == 0)){
            areThereCarrots = true;
        }
        return areThereCarrots;
    }
    public static boolean escapecard(String newplayerlocation, String escape){
        boolean hellExit = false;
        if (newplayerlocation.equals(escape)){
            hellExit = true;

        }
        return hellExit;
    }

    public static boolean exitToHell(String newplayerlocation, String hell){
        boolean hellExit = false;
        if (newplayerlocation.equals(hell)){
            hellExit = true;

        }
        return hellExit;
    }

    public static boolean exitToHeaven(String newplayerlocation, String heaven){
        boolean heavenexit = false;
        if (newplayerlocation.equals(heaven)){
            heavenexit = true;
        }
        return heavenexit;
    }

    public static void CarrotLocations(int S){
        System.out.println("Carrots were at: ");
        for (int m = 1; m<=S; m++) {
            for (int n = 1; n <= 2 * S - 1; n++) {
                if (m % 2 == 0 && n % 2 == 0) {
                    System.out.print("(" + m + "," + n + ")");
                }
            }
        }
    }


    public static boolean isThereaRabbit(String rabbit1, String rabbit2,String rabbit3,String newplayerlocation){
        boolean rabbitCheck = false;
        if (rabbit1.equals(newplayerlocation)||rabbit2.equals(newplayerlocation)||rabbit3.equals(newplayerlocation)){
            rabbitCheck = true;
        }

        return rabbitCheck;
    }


    public static boolean isThereaRat(String rat1,String rat2, String newplayerlocation){
        boolean ratCheck= false;
        if (rat1.equals(newplayerlocation)||rat2.equals(newplayerlocation)){
            ratCheck = true;
        }
        return ratCheck;
    }

    public static boolean canMove(int answer, int randomplayerx,int randomplayery, int S ){
        Scanner sc = new Scanner(System.in);
        boolean canMove = false;
        if (answer==8){
            if (randomplayery==1||randomplayery==2*randomplayerx-1){
                canMove = true;
            }
        }

        if (answer==2){
            if (randomplayerx==S){
                canMove=true;
            }
        }

        if (answer==6) {
            if (randomplayery == 2 * randomplayerx - 1) {
                canMove=true;
            }
        }
        if (answer==4) {
            if (randomplayery == 1) {
                canMove=true;
            }
        }
        return canMove;
    }


}