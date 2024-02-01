import java.util.Scanner;

public class PROJECT3fınal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*********************************************************************************************");
        System.out.println("Welcome to “RABBITS IN THE WOODS” \nin this game you can have players as much as you want. \nTo win this game you will try to find heaven or collect most points. \nIf you come across a rat you will loose some carrots, \nthere will be some carrots on the even numbered locations, \ntry to collect carrots by answering the arithmetic questions, \nyou can gain game points by feeding the carrots to the rabbits.\nGOOD LUCK... (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
        System.out.println("*********************************************************************************************");
        System.out.println("");
        System.out.println("Enter the size of the game area: (min 4)");
        int S =0;
        while (true){
            S = sc.nextInt();
            if (S<4){
                System.out.println("(╬ Ò﹏Ó)\nI said min 4 ,Please enter again: ");
            }else break;
        }


        //carrots(S);
        int randomhellx,randomhelly,randomheavenx,randomheaveny,randomrabbit2x,randomrabbit2y,randomrabbit3x,randomrabbit3y,randomrat1x,randomrat1y,randomrat2x,randomrat2y,randomplayerx,randomplayery;
        int carrotAmount =0;
        int carrotslost =0;
        int carrotcount =0;
        int gamepointslost =0;
        int gamepointswon =0;
        int rabbitcounter =0;
        int ratcounter =0;
        int totalgamepoints =0;
        int carrotsfed =0;

        String rabbit2,rabbit1,rabbit3,rat1,rat2,player,hell,heaven;
        String newplayerlocation = "";

        int i =0;

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
            randomhellx = randomx(S);
            randomhelly = randomy(randomhellx);
            hell = "("+ randomhellx + "," + randomhelly + ") ";
        }while (hell.equals(rabbit1)||hell.equals(rabbit2)||hell.equals(rabbit3)||hell.equals(rat2)||hell.equals(rat1));


        do {
            randomheavenx = randomx(S);
            randomheaveny = randomy(randomheavenx);
            heaven = "("+ randomheavenx+ "," + randomheaveny + ") ";
        }while (heaven.equals(rabbit1)||heaven.equals(rabbit2)||heaven.equals(rabbit3)||heaven.equals(rat2)||heaven.equals(rat1)||heaven.equals(hell));

        System.out.println("Enter how many players you would like to add: ");
        int playercount = sc.nextInt();
        int[] players = new int[playercount];int[] Xofplayers = new int[playercount];int[] Yofplayers = new int[playercount];int[] Carrotcount = new int[playercount];int[] ratvisitor = new int[playercount];int[] rabbitvisitor = new int[playercount];int[] gamePoints = new int[playercount];int[] Carrotsfed = new int[playercount];
        boolean taketurn = true;
        String[] locationofplayers = new String[playercount];
        for (int m =0; m<locationofplayers.length; m++){
            do {
                randomplayerx = randomx(S);
                randomplayery = randomy(randomplayerx);
                Xofplayers[m] = randomplayerx;
                Yofplayers[m] = randomplayery;
                player = "("+ randomplayerx + "," + randomplayery + ") ";
                locationofplayers[m] = player;
                newplayerlocation = player;
            }while (player.equals(rabbit1)||player.equals(rabbit2)||player.equals(rabbit3)||player.equals(rat2)||player.equals(rat1)||player.equals(hell)||player.equals(heaven));


        }

        //WHILE LOOP WILL START FROM HERE
        for (i =0; i<players.length; i++){
            for (int n =0; n<locationofplayers.length; n++){
                System.out.println("player " +(n+1) + " at:  "+locationofplayers[n]);
            }
            int m = i;
            taketurn = true;
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("Turn of player:  " + (i+1) +" -> " + locationofplayers[i]);
            System.out.println("---------------------------------------------------------------------------------");
            while (taketurn){
                randomplayery = Yofplayers[i];
                randomplayerx = Xofplayers[i];
                carrotAmount = Carrotcount[i];
                area(S,Xofplayers[i], Yofplayers[i]);
                System.out.println("---------------------------------------------------------------------------------");


                boolean movement = true;
                while (movement){
                    int answer = movement();
                    if (answer==8){
                        if (randomplayery==1||randomplayery==2*randomplayerx-1){
                            System.out.println("invalid movement please choose again!!");
                        }else{
                            randomplayerx= movingx(randomplayerx,answer);
                            randomplayery=movingy(randomplayery,answer);
                            movement = false;
                            break;
                        }

                    }

                    if (answer==2){
                        if (randomplayerx==S){
                            System.out.println("invalid movement please choose again");
                        }else{
                            randomplayerx= movingx(randomplayerx,answer);
                            randomplayery=movingy(randomplayery,answer);
                            movement = false;
                            break;
                        }
                    }


                    if (answer==6){
                        if (randomplayery==2*randomplayerx-1){
                            System.out.println("invalid movement please choose again");
                        }else{
                            randomplayery=movingy(randomplayery,answer);
                            movement = false;
                            break;
                        }
                    }

                    if (answer==4){
                        if (randomplayery==1){
                            System.out.println("invalid movement please choose again");
                        }else{
                            randomplayery=movingy(randomplayery,answer);
                            movement = false;
                            break;
                        }
                    }

                }



                newplayerlocation = "("+ randomplayerx + "," + randomplayery + ") ";
                locationofplayers[i] = newplayerlocation;
                Xofplayers[m] = randomplayerx;
                Yofplayers[m] = randomplayery;

                boolean exittohell = exitToHell(newplayerlocation,hell);//if the player finds hell their game points will be 0.
                if (exittohell){
                    System.out.println("HELLLLLL (╥﹏╥)");
                    Carrotcount[i] =0;
                    gamePoints[i] =0;
                    break;
                }


                boolean exittoheaven =exitToHeaven(newplayerlocation,heaven);
                if (exittoheaven){
                    System.out.println("HEAVENN ᕙ(`▿´)ᕗ");
                    break;
                }


                boolean carrotCheck= isThereACarrot(randomplayerx,randomplayery);
                if (carrotCheck){
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
                if (rabbitcheck){
                    rabbitcounter++;
                    System.out.println("==========================================================================");
                    System.out.println("YOU CAME ACROSS A RABBIT ૮꒰˶• ༝ •˶꒱ა ");
                    int wantedcarrots = randomcarrots();
                    System.out.println("This rabbit wants " + wantedcarrots + " carrots");
                    if (wantedcarrots>carrotAmount){
                        System.out.println("You don't have enough carrots to feed the rabbit.");
                        gamepointslost = (int)(Math.random()*10+1);
                        System.out.println("you will loose some game points game points lost = " + gamepointslost);
                        System.out.println("==========================================================================");
                        totalgamepoints = totalgamepoints-gamepointslost;
                    }else {
                        carrotAmount = carrotAmount-wantedcarrots;
                        System.out.println("You fed "+ wantedcarrots+ "to the rabbit, you have " + carrotAmount + " carrots left");
                        carrotsfed = wantedcarrots;
                        gamepointswon = wantedcarrots*10;
                        System.out.println("you won " + gamepointswon + " game points");
                        System.out.println("==========================================================================");
                        totalgamepoints += gamepointswon;
                    }

                }



                boolean ratcheck =isThereaRat(rat1,rat2,newplayerlocation);
                if (ratcheck){
                    ratcounter++;
                    carrotslost = randomcarrots();
                    System.out.println("==========================================================================");
                    System.out.println("YOU CAME ACROSS A RAT …ᘛ⁐̤ᕐᐷ, IT WILL STEAL SOME OF YOUR CARROTS ");
                    if (carrotAmount==0){
                        System.out.println("THE RAT COULDN'T FIND ANY CARROTS TO STEAL, BECAUSE YOU DON'T HAVE ANY");
                        System.out.println("==========================================================================");
                    }else if (carrotslost>carrotAmount){
                        System.out.println("RAT STOLE ALL OF YOUR CARROTS");
                        System.out.println("==========================================================================");
                        carrotAmount = 0;

                    }else{

                        System.out.println("you have lost " + carrotslost + " carrots");
                        System.out.println("==========================================================================");
                        carrotAmount = carrotAmount-carrotslost;
                    }

                }
                gamePoints[i] = gamePoints[i] + totalgamepoints;
                Carrotcount[i] = carrotAmount;
                rabbitvisitor[i] = rabbitvisitor[i] + rabbitcounter;
                ratvisitor[i] = ratvisitor[i] + ratcounter;
                Carrotsfed[i] = Carrotsfed[i] + carrotsfed;

                totalgamepoints =0;rabbitcounter=0;ratcounter =0;carrotsfed=0;carrotAmount=0;

                System.out.println("---------------------------------------------------------------------------------");
                for (int q =0; q<Carrotcount.length; q++){
                    System.out.println("STATS OF: " +(q+1));
                    System.out.println("(CARROT AMOUNT "+": "+ Carrotcount[q] + ") (GAME POINTS: " + gamePoints[q] + ") (RABBITS VISITED: "+ rabbitvisitor[q] + ") (RATS VISITED: " + ratvisitor[q] + ")");
                }
                System.out.println("---------------------------------------------------------------------------------");
                taketurn = false;
            }


            if (locationofplayers[i].equals(hell)||locationofplayers[i].equals(heaven)){
                break;
            }


            if (i==players.length-1){
                i =-1;
            }
        }
        System.out.println("---------------------------------------------------------------------------------");
        for (int q =0; q<Carrotcount.length; q++){
            System.out.println("STATS OF: " +(q+1)+ ": ");
            System.out.println("(CARROT AMOUNT "+": "+ Carrotcount[q] + ") (GAME POINTS: " + gamePoints[q] + ") (RABBITS VISITED: "+ rabbitvisitor[q] + ") (RATS VISITED: " + ratvisitor[q] +")");
        }
        System.out.println("---------------------------------------------------------------------------------");


        int maxgamepoint = maxgamepoint(players,gamePoints,locationofplayers,hell);
        int maxgamepointedplayer = maxgamepointplayer(players,gamePoints);
         String rabbitfeeder = findrabbitfeeder(players,rabbitvisitor);
         if (rabbitfeeder.equals(" ")){
             System.out.println("There are no rabits fed");
         }else {
             System.out.println(rabbitfeeder);
         }
         String Carrotcollector =findCarrotCollector(players,Carrotcount);
         if (Carrotcollector.equals(" ")){
             System.out.println("There are no carrots collected");
         }else {
             System.out.println(Carrotcollector);
         }
         String ratvisit = findratvisitor(players,ratvisitor);
         if (ratvisit.equals(" ")){
             System.out.println("There are no rats visited");
         }else {
             System.out.println(ratvisit);
         }



        for (int j=0; j<players.length; j++){
            if (locationofplayers[j].equals(heaven)){
                System.out.println("player " + findwinner(locationofplayers,heaven,hell,gamePoints) + " found heaven,they are the winner.");
                break;
            } else if (locationofplayers[j].equals(hell) && players.length==2) {
                System.out.println("player " +(j+1)+ "found hell!!!"+ "Other player is the winner");
            } else if (locationofplayers[j].equals(hell)&&findwinner(locationofplayers,heaven,hell,gamePoints)==0) {
                System.out.println("player " +(j+1)+ "found hell!!!, They lost "+  "The others have 0 points, it's a tie");
            } else if (locationofplayers[j].equals(hell)&&tieCheck(players,gamePoints,hell,locationofplayers,heaven)>0) {
                System.out.println("player " +(j+1)+ " found hell!!!  \\(˚☐˚”)/");
                if (tieCheck(players,gamePoints,hell,locationofplayers,heaven)>=0){
                    System.out.println(tieChecker(players,gamePoints,hell,locationofplayers,heaven));

                }else{
                    System.out.println("player with maximum game points: " + findwinner(locationofplayers,heaven,hell,gamePoints) + " They have: " + maxgamepoint );
                }
            }


        }







        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Rabbits were at: " + rabbit1+ "," + rabbit2 + "," + rabbit3 );
        System.out.println("Rats were at: " + rat1 + "," + rat2);
        System.out.println("Heaven was at: " + heaven);
        System.out.println("Hell was at: " + hell);
        CarrotLocations(S);
        System.out.println("\n---------------------------------------------------------------------------------");

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

    public static int movingx(int x, int answer){
        if (answer==8){
            x--;
        }else {
            x++;
        }
        return x;
    }

    public static int movingy(int y, int answer){
        if (answer==8||answer==4){
            y--;
        } else if (answer==2||answer==6) {
            y++;

        }
        return y;
    }

    public static int randomx(int S){
        return (int)(Math.random()*S+1);
    }
    public static int randomy(int S){
        return (int)(Math.random()*(2*S-1)+1);
    }

    public static void area(int S, int playerx, int playery){
        int i =0;
        int j = 0;



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
        return (int)(Math.random()*10+1);
    }

    public static boolean isThereACarrot(int randompalyerx,int randomplayery){
        return ((randompalyerx % 2) == 0) && ((randomplayery % 2) == 0);
    }

    public static boolean exitToHell(String newplayerlocation, String hell){
        return newplayerlocation.equals(hell);
    }

    public static boolean exitToHeaven(String newplayerlocation, String heaven){
        return newplayerlocation.equals(heaven);
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
        return rabbit1.equals(newplayerlocation) || rabbit2.equals(newplayerlocation) || rabbit3.equals(newplayerlocation);
    }

    public static boolean isThereaRat(String rat1,String rat2, String newplayerlocation){
        return rat1.equals(newplayerlocation) || rat2.equals(newplayerlocation);
    }

    public static String findCarrotCollector(int[] players, int[] carrotcounts){
        int maxCarrots= 0;
        String answer = " ";
        for (int i =0; i<players.length; i++) {
            if (carrotcounts[i] > maxCarrots) {
                maxCarrots = carrotcounts[i];
                answer = "->MAX CARROT COLLECTOR: " + (i + 1) + ", COLLECTED CARROTS: " + maxCarrots+ " <-";
            }

        }
        return answer;
    }


    public static String findrabbitfeeder(int[] players, int[] rabbitvisitor){
        int max =players[0];
        String answer =" ";
        for (int i =0; i<players.length; i++){
            if (rabbitvisitor[i]>max){
                max = rabbitvisitor[i];

                answer = "-> MAX RABBIT VISITOR: " + (i+1) +", RABBITS VISITED: "+max + "<-";
            }

        }

        return answer;


    }
    public static String findratvisitor(int[] players, int[] ratvisitor){
        int max =0;
        int temp =0;
        String answer = " ";
        for (int i =0; i<players.length; i++){
            if (ratvisitor[i]>max){
                max = ratvisitor[i];
                answer = "-> MAX RAT VISITOR: " + (i+1) +", RATS VISITED: "+max + " <-";
            }

        }

        return answer;


    }

    public static int tieCheck(int[] players, int[] gamepoints, String hell,String[] locationofplayers, String heaven){
        int max = 0;
        int maxplayer = 0;
        String ties1 ="";
        String ties2 ="";

        int tie =0;
        int i =0;
        for (i=0; i<gamepoints.length;i++){
            if (gamepoints[i]>max&&!locationofplayers[i].equals(hell)){
                max=gamepoints[i];
                maxplayer=i;
            }
        }

        ties1 = (maxplayer+1) + "";
        for (int j=0;j<gamepoints.length;j++){
            if (j!=maxplayer&&max==gamepoints[j]&&!locationofplayers[j].equals(hell)){
                tie++;
                ties2 = ties2 + ","+ (j+1) ;

            }
        }
        ties1 = ties1 + ""+  ties2;


       return tie;
    }

    public static String tieChecker(int[] players, int[] gamepoints, String hell,String[] locationofplayers, String heaven){
        int max = 0;
        int maxplayer = 0;
        String ties1 ="";
        String ties2 ="";

        int tie =0;
        int i =0;
        for (i=0; i<gamepoints.length;i++){
            if (gamepoints[i]>=max&&!locationofplayers[i].equals(hell)){
                max=gamepoints[i];
                maxplayer=i;
                ties1 = (maxplayer+1) + "";
            }
        }


        for (int j=0;j<gamepoints.length;j++){
            if (j!=maxplayer&&max==gamepoints[j]&&!locationofplayers[j].equals(hell)){
                tie++;
                ties2 = ties2 + ","+ (j+1);

            }
        }
        ties1 = ties1 + ""+  ties2;
        System.out.println("WINNER/S: "+ties1 + " POINTS: "+ max);


        return "⋆｡‧˚ʚ♡ɞ˚‧｡⋆";
    }


    public static int maxgamepointplayer(int[] players, int[] gamepoints){
        int maxpoints = gamepoints[0];
        int maxpointplayer =0;
        for (int i =0; i<players.length; i++){
            if (gamepoints[i] > maxpoints){
                maxpoints = gamepoints[i];
                maxpointplayer = i;
                break;
            }

        }
        return maxpointplayer +1;
    }

    public static int maxgamepoint (int[] players, int[] gamepoints,String[] playerlocations, String hell){
        int maxpoints = 0;
        for (int i =0; i<players.length; i++){
            if (!playerlocations[i].equals(hell)&&gamepoints[i]>maxpoints){
                maxpoints = gamepoints[i];

            }

        }
        return maxpoints;

    }


    public static int findwinner(String[] locationofplayers, String heaven,String hell, int[] gamepoints){
        int winner =0;
        int maxgamepoins=0;
        for (int i =0; i<locationofplayers.length; i++){
            if (locationofplayers[i].equals(heaven)){
                winner = i+1;
            }else {
                for (int j =0; j<gamepoints.length; j++){
                    if (!locationofplayers[j].equals(hell)&&gamepoints[j]>=maxgamepoins){
                        maxgamepoins = gamepoints[j];
                        winner = j+1;
                    }
                }


            }


        }
        return winner;
    }

}