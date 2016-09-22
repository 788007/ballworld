
/**
 * @Laurel Woods 
 * @activity 4
 */
public class BallRunner
{
    static BallBot[] ballBotArray;
    BallWorld ballWorld;
    TGPoint entrancePoint;
    public BallRunner(BallWorld ballWorld, TGPoint startPoint, int ballBotArrayLength){
        ballWorld = ballWorld;
        entrancePoint = entrancePoint;
        ballBotArray = new BallBot[ballBotArrayLength];
    }

    public static void run(){
        BallWorld ballWorld = new BallWorld(700, 700);
        TGPoint entrancePoint = new TGPoint (0, 0);
        int ballBotArrayLength = 15;
       

        BallRunner ballObject = new BallRunner(ballWorld, entrancePoint, ballBotArrayLength);

        while (1 > 0) {
            int freeBallBotIndex = -1;
            for (int j = 0; j < ballBotArray.length; j++) {
                freeBallBotIndex = ballObject.findFreeBallBotIndex();
                if (freeBallBotIndex < ballBotArray.length) {
                    if (freeBallBotIndex == 0) {
                        BallBot ballBot = new BallBot(ballWorld, entrancePoint, (int)(Math.random()*360), (int)(Math.random()*35 + 5));
                        ballBotArray[freeBallBotIndex] = ballBot;
                        ballBot.setColor((int)(Math.random()*32));
                        ballBot.setPixelsPerSecond((int)(Math.random()*130 + 30));
                    } else {
                        if (ballObject.entranceClear(freeBallBotIndex, entrancePoint) && ballObject.ballBotToBounceOff(j) == false) {
                            BallBot ballBot = new BallBot(ballWorld, entrancePoint, (int)(Math.random()*360), (int)(Math.random()*35 + 5));
                            ballBotArray[freeBallBotIndex] = ballBot;
                            ballBot.setColor((int)(Math.random()*32));
                            ballBot.setPixelsPerSecond((int)(Math.random()*130 + 30));
                        }
                    }
                }
            }

            for (int i = 0; i < ballBotArray.length; i++) {
                if (ballBotArray[i] != null ){
                    if (ballBotArray[i].canMoveForward(ballWorld) == true){
                        if (ballObject.ballBotToBounceOff(i)) {
                            ballBotArray[i].setHeading((ballBotArray[i].getHeading() + 300)%360);
                            ballBotArray[i].setColor(ballBotArray[i].getColor() +((int)(Math.random()*32))%32);
                            ballBotArray[i].moveForward();
                        } else {
                            ballBotArray[i].moveForward();
                        }
                    }else {
                        ballBotArray[i].setHeading((int)(Math.random()*360));
                        ballBotArray[i].setColor(ballBotArray[i].getColor() +((int)(Math.random()*32))%32);
                        ballBotArray[i].moveForward();
                    }
                    
                }

            }
           
        }
    }

    public int findFreeBallBotIndex() {
        for (int i = 0; i < ballBotArray.length; i ++) {
            if (ballBotArray[i] == null) {
                return i;
            } 
        }
        return ballBotArray.length;
    }

    public double distanceBetweenPoints (TGPoint point1, TGPoint point2) {
        double xDiff = point1.x - point2.x;
        double yDiff = point1.y - point2.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public boolean entranceClear(int x , TGPoint entrancePoint){
        //boolean clear = false;
        //for (int i = 0; i < ballBotArray.length; i++) {
            if (ballBotArray[x - 1] != null){
                if (distanceBetweenPoints(entrancePoint, ballBotArray[x - 1].getPoint()) < 80 ) {
                    return false;
                } else {
                    return true; 
                }
            }
        //}
        //return clear;
        return false;
    }
    
    public boolean ballBotToBounceOff (int testIndex) {
        TGPoint point = ballBotArray[testIndex].getPoint();
        TGPoint nextPoint = ballBotArray[testIndex].forwardPoint();
        for (int i = 0; i < ballBotArray.length; i++) {
            if(i != testIndex && ballBotArray[i] != null) {
                if(distanceBetweenPoints(point, ballBotArray[i].getPoint()) <= (ballBotArray[testIndex].getRadius() + ballBotArray[i].getRadius())){
                    if(distanceBetweenPoints(nextPoint, ballBotArray[i].forwardPoint()) < (ballBotArray[testIndex].getRadius() + ballBotArray[i].getRadius())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //     public static void activity1() {
    //         BallWorld ballWorld = new BallWorld(500, 500);
    //         TGPoint startPoint = new TGPoint (0, 0);
    //         BallBot ballBot = new BallBot(ballWorld, startPoint, 0, 25);
    //         while(1 > 0) {
    //             if (ballBot.canMoveForward(ballWorld)){
    //                 ballBot.moveForward();
    //             }else {
    //                 ballBot.setHeading((ballBot.getHeading()+120)%360);
    //             }
    //         }
    //     }
}