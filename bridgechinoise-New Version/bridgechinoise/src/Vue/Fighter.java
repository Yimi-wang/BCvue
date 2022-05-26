package Vue;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Fighter implements Runnable{
    private List<Card> fighterCards;
    private Container container;

    private boolean isSendingCard;

    private List<Card> sentCards;
    private List<Card> frontCards;





    public Fighter(Container container, List<Card> fighterCards, boolean isSendingCard, List<Card> sentCards, List<Card> frontCards){
        this.container = container;
        this.fighterCards = fighterCards;
        this.isSendingCard = isSendingCard;
        this.sentCards = sentCards;
        this.frontCards = frontCards;
    }


    @Override
    public void run() {
        Time.second(2);

        fighterSendCard();

    }

    public void fighterSendCard(){
        int size = fighterCards.size();
        int i = new Random().nextInt(size);
        Card card1 = fighterCards.get(i);
        fighterCards.remove(card1);
        sentCards.add(card1);
        frontCards.add(card1);
        Point point = new Point();
        point.setLocation(350, 300);
        Common.move(card1, card1.getLocation(), point);
        Common.rePosition(container,fighterCards, 1);

    }
}
