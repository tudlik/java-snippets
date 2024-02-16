package cz.jty.hannoiTowers;

import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Kotouc kotouc1= new Kotouc(1, "    ██    ");
        Kotouc kotouc2= new Kotouc(2, "   ████   ");
        Kotouc kotouc3= new Kotouc(3, "  ██████  ");
        Kotouc kotouc4= new Kotouc(4, " ████████ ");
        Kotouc kotouc5= new Kotouc(5, "██████████");

        Stack<Kotouc> stack1 = new Stack<>();
        Stack<Kotouc> stack2 = new Stack<>();
        Stack<Kotouc> stack3 = new Stack<>();

        stack1.push(kotouc5);
        stack1.push(kotouc4);
        stack1.push(kotouc3);
        stack2.push(kotouc2);
        stack3.push(kotouc1);

        HashMap<Integer, Stack<Kotouc>> hashMapStacks = new HashMap<>(Map.ofEntries(Map.entry(1,stack1), Map.entry(2,stack2), Map.entry(3,stack3)));

        boolean vyhra=false;
        while (!vyhra){
            renderStacks(stack1, stack2, stack3);
            System.out.print("Přesunout kotouč z věže: ");
            int fromTower= Integer.parseInt(scanner.nextLine());
            System.out.print("Přesunout kotouč na věž: ");
            int toTower= Integer.parseInt(scanner.nextLine());
            moveCircle(fromTower, toTower, hashMapStacks);
            vyhra=winCheck(hashMapStacks);
            if(vyhra){
                renderStacks(stack1, stack2, stack3);
                System.out.println("Vyhrál jsi!");
            }
        }

    }

    private static void moveCircle(int from, int to, HashMap<Integer, Stack<Kotouc>> hashMap){
        Kotouc circleTomove;
        if(hashMap.get(from).size()!=0){
            circleTomove= hashMap.get(from).pop();
            hashMap.get(to).push(circleTomove);
        }
    }

    private static boolean winCheck (HashMap<Integer, Stack<Kotouc>> hashMap){
        boolean win=false;
        for(Map.Entry<Integer, Stack<Kotouc>> entry : hashMap.entrySet()){
            if (entry.getValue().size()==5){
                int index = 5;
                for(Kotouc circle : entry.getValue()){
                    if (circle.getID()==index){
                        win=true;
                        index--;
                    }else{
                        win=false;
                        break;
                    }
                }
            }
        }
        return win;
    }

    private static List<String> stackToArray(Stack<Kotouc> stack){
        List<String> stackToList = new ArrayList<>();

        for (Kotouc kotouc : stack){
            stackToList.add(kotouc.getText());
        }


        if(stack.size()<5){
            for(int i=0; i<(5-stack.size());i++){
                stackToList.add("          ");
            }
        }


        Collections.reverse(stackToList);
        return stackToList;
    }

    private static void renderStacks (Stack<Kotouc> stack1,Stack<Kotouc> stack2, Stack<Kotouc> stack3) {
        List<String> stackOne = stackToArray(stack1);
        List<String> stackTwo = stackToArray(stack2);
        List<String> stackThree = stackToArray(stack3);
//        System.out.println("stackOne size: " + stackOne.size());
//        System.out.println("stackTwo size: " + stackTwo.size());
//        System.out.println("stackThree size: " + stackThree.size());

        System.out.println("     1          2          3");
        for (int i=0;i<5;i++){
            System.out.print(stackOne.get(i)+" "+stackTwo.get(i)+" "+stackThree.get(i));
            System.out.println();
        }

    }

}