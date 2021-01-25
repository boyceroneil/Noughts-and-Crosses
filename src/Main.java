import java.util.*;
public class Main {

    static String[][] map = new String[3][3];
    static String user1;

    public static void main(String[] args) {
        //maybe use maps or double array
        //make sure that the space occupied isn't reused
        //display the lines through system.out.println
        //win condition exits the program and draw condition. so probably do something when all spaces are filled
        //update: win condition does not fully work
//        LinkedHashMap<Integer,String> hm=new LinkedHashMap<Integer,String>();
//        hm.put(1,"x");
        //String[][] map = new String[3][3];
        int vert =0, hori =0;
        int counter = 0;
        int place = 0;
        Scanner input1 = new Scanner(System.in);
        Scanner Ninput1 = new Scanner(System.in);
        Scanner Ninput11 = new Scanner(System.in);

        System.out.println("The rules are simple:  \n" +
                "You can use x or o. try to get 3 in a row. be aware that computer might cheat");
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                map[i][j] = "" + (place);
                place++;
            }
        }
        for (String[] strings : map) {
            for (int j = 0; j < map.length; j++) {
                System.out.print("[" + strings[j] + "]" + " ");

            }
            System.out.println();
        }
        do{
            System.out.println("Player 1: Type number for horizontal");
            vert = Ninput1.nextInt();

            System.out.println("Player 1: Type number for vertical");
            hori = Ninput11.nextInt();

            System.out.println("Player 1: Type letter x or o to occupied that position");
             user1 = input1.nextLine();
            map[hori][vert]= user1;
            turnChange(map, user1);


//            System.out.println("Player 2: Type number first for space");
//            int Nuser2 = Ninput2.nextInt();
//            System.out.println("Player 2: Type letter x or o to occupied that position");
//            String user2 = input2.nextLine();

            //hm.put(Nuser1,user1);
            counter +=1;
            //hm.put(Nuser2,user2); //test with do while loop

            counter+=1;
            int d = counter;
            while (d > 5 && d < 9) {
            if(three(map)) {
                d=10;
                counter=10;
            }
                d++;
//                }
//            else{
//                d=10;
//                counter = 10;
            }
                
            //}
            for(int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    System.out.print("[" + map[i][j] + "]" + " ");

                }
                System.out.println();
            }
        }while(counter<9);
System.out.println("Thank you for playing");
        }


public static void turnChange(String[][] map, String user1) {//partial computer reading
    boolean moved = false;
    String com = "x";
    if (user1.equals("x")) {
        com = "o";
    }

    for (int i = 0; i < 3; i++) {
        if (map[0][i].equals(map[1][i]) && map[0][i].equals(user1)) {//&& map[0][i].equals("")

            if (!map[2][i].equals(user1) && !map[2][i].equals(user1)) {
                map[2][i] = com;
                moved = true;
                return;
            }

        }

    }
    for (int i = 0; i < 3; i++) {

        if (map[2][i].equals(map[1][i]) && map[2][i].equals(user1)) {

            if (!map[0][i].equals(user1)) {
                map[0][i] = com;
                moved = true;
                return;
            }

        }


    }



    for (int i = 0; i < 3; i++) {//win horizontally

        if (map[i][0].equals(map[i][1]) && map[i][0].equals(user1)) {

            if (!map[i][2].equals(user1) && !map[i][2].equals(user1)) {
                map[i][2] = com;
                moved = true;
                return;
            }

        }

    }

    for (int i = 0; i < 3; i++) {

        if (map[i][2].equals(map[i][1]) && map[i][2].equals(user1)) {

            if (!map[i][0].equals(user1)) {
                map[i][0] = com;
                moved = true;
                return;
            }

        }

    }




    if (map[0][0].equals(map[1][1]) && map[0][0].equals(user1)) {//win diagonally bottom

        if (!map[2][2].equals(user1)) {
            map[2][2] = com;
            moved = true;
            return;
        }
    }

    if (map[2][2].equals(map[1][1]) && map[2][2].equals(user1)) {

        if (!map[0][0].equals(user1)) {
            map[0][0] = com;
            moved = true;
            return;
        }
    }
    if (map[0][0].equals(map[1][1]) && map[0][0].equals(user1)) {
        if (map[2][2] != user1 && !map[2][2].equals(user1)) {
            map[2][2] = com;
            moved = true;
            return;
        }
    }

    if (map[0][2].equals(map[1][1]) && map[0][2].equals(user1)) {

        if (map[2][0] != user1 && !map[2][0].equals(user1)) {
            map[2][0] = com;
            moved = true;
            return;
        }
    }

    if (map[2][0].equals(map[1][1]) && map[2][0].equals(user1)) {

        if (!map[0][2].equals(user1)) {
            map[0][2] = com;
            moved = true;
            return;
        }
    }
    int rand1 = 0;
    int rand2 = 0;

    while (!moved) {

        rand1 = (int) (Math.random() * 3);
        rand2 = (int) (Math.random() * 3);

        if (map[rand1][rand2] != "x" && map[rand1][rand2] != "o") {
            map[rand1][rand2] = com;
            moved = true;

        }
    }
}

// 036, 012, 048 147, 258, 246, 345, 678 Map<Integer, String> hm
    public static boolean three(String map[][]){
        //declare winner conditions
        boolean wins = false;
        if(map[0][0]==map[1][0] && map[1][0]==map[2][0]){//vertical left  hm.get(0)== hm.get(6) && hm.get(6)== hm.get(3)
            if(map[2][0] == user1){
                System.out.println(user1+ " this is the winner");
            }//            counter =9;
//            d =9;
            wins = true;

        }
        else if(map[0][0]==map[0][1] && map[0][1]==map[0][2]){//horizontal top hm.get(0)== hm.get(1) && hm.get(1)== hm.get(2)
            if(map[2][0] == user1){
                System.out.println(user1+ " this is the winner");
            }else{
                //            counter =9;
            }
//            d =9;
            wins = true;
        }
        else if(map[0][0]==map[1][1] && map[1][1]==map[2][2]){ //diagnol top left to bottom right  hm.get(0)== hm.get(4) && hm.get(4)== hm.get(8)

            if(map[2][0] == user1){
                System.out.println(user1+ " this is the winner");
            }//            counter =9;
//            d =9;
            wins = true;
        }
        else if(map[0][1]==map[1][1] && map[1][1]==map[2][1]){//vertical middle  hm.get(1)== hm.get(4) && hm.get(7)== hm.get(4)

            if(map[2][0] == user1){
                System.out.println(user1+ " this is the winner");
            }//            counter =9;
//            d =9;
            wins = true;
        }
        else if(map[0][2]==map[1][2] && map[1][2]==map[2][2]){//vertical right hm.get(2)== hm.get(5) && hm.get(5)== hm.get(8)
            if(map[2][0] == user1){
                System.out.println(user1+ " this is the winner");
            }//            counter =9;
//            d =9;
            wins = true;
        }
        else if(map[0][2]==map[1][1] && map[1][1]==map[2][0]){//diagnol top right to bottom left  hm.get(2)== hm.get(4) && hm.get(4)== hm.get(6)
            if(map[2][0] == user1){
                System.out.println(user1+ " this is the winner");
            }//            counter =9;
//            d =9;
            wins = true;
        }
        else if(map[1][0]==map[1][1] && map[1][1]==map[1][2]){//horizontal middle hm.get(3)== hm.get(4) && hm.get(4)== hm.get(5)
            if(map[2][0] == user1){
                System.out.println(user1+ " this is the winner");
            }//            counter =9;
//            d =9;
            wins = true;
        }
        else if(map[2][0].equals(map[2][1]) && map[2][1].equals(map[2][2])){ //horizontal bottom hm.get(6)== hm.get(7) && hm.get(7)== hm.get(8)
            if(map[2][0] == user1){
                System.out.println(user1+ " this is the winner");
            }
//            counter =9;
//            d =9;
            wins = true;
        }
        else{// no winner
            System.out.println("No winner");
//            counter++;
//            d++;
        }
        return wins;
    }


}


