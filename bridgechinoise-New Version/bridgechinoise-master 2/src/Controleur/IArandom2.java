//package Controleur;
//
//import Modele.Jeu;
//
//import java.util.Objects;
//import java.util.Random;
//
//import static Modele.Playcards.limite;
//
//public class IArandom2 {
//    public static int IArandomPlayerCard2(Jeu j){
//        Random r = new Random();
//        if (j.getPlayerNow()==0){
//            if(j.getPlayerfirst()==j.getPlayerNow()){
//                return r.nextInt(j.playercard[0].size());
//            }
//            else{
//                int index=r.nextInt(j.playercard[0].size());
//                System.out.println("le index est:" + index);
//                while(limite(j,j.getFirstPlayerPlayCard())&&(!Objects.equals(j.playercard[0].get(index).getInttype(), j.getFirstPlayerPlayCard().getInttype()))){
//                    index=r.nextInt(j.playercard[0].size());
//                }
//                return index;
//            }
//        }
//        return -1;
//    }
//
//    public static int IarandomGetCard2(Jeu j){
//        Random r = new Random();
//        int index =r.nextInt(6);
//        if(j.getPlayerNow()==0){
//            while (j.pilescard[index].size()==0){
//                index =r.nextInt(6);
//            }
//        }
//        return index;
//    }
//
//}