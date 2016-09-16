
/**
 * @Laurel Woods 
 * @activity 2
 */
public class BallRunner
{
    static BallBot[] ballBotArray;
    BallWorld ballWorld;
    TGPoint entrancePoint;
    public BallRunner(BallWorld ballWorld, TGPoint entrancePoint, int ballBotArrayLength){
        ballWorld = ballWorld;
        entrancePoint = entrancePoint;
        ballBotArray = new BallBot[ballBotArrayLength];
    }
    public int findFreeBallBotIndex() {
        for (int i = 0; i < ballBotArray.length; i ++) {
            if (ballBotArray[i] == null) {
                return i;
            } 
        }
        return ballBotArray.length;
    }
    public static void run(){
        BallWorld ballWorld = new BallWorld(500, 500);
        TGPoint entrancePoint = new TGPoint (0, 0);
        int ballBotArrayLength = 10;
        
        BallRunner ballObject = new BallRunner(ballWorld, entrancePoint, ballBotArrayLength);
        for (int j = 0; j < ballBotArray.length; j++) {
            int freeBallBotIndex = ballObject.findFreeBallBotIndex();
            if (freeBallBotIndex < ballBotArray.length) {
                BallBot ballBot = new BallBot(ballWorld, entrancePoint, (int)(Math.random()*360), 20);
                ballBotArray[freeBallBotIndex] = ballBot;
            }
        }
        while (1 > 0) {
            for (int index = 0; index < ballBotArray.length; index++) {
                if (ballBotArray[index] != null ){
                    if (ballBotArray[index].canMoveForward(ballWorld) == true){
                        ballBotArray[index].moveForward();
                   }else {
                       ballBotArray[index].setHeading((int)(Math.random()*360));
                       ballBotArray[index].moveForward();
                   }

                }
            }
        }
    }
    
    public static void activity1() {
        BallWorld ballWorld = new BallWorld(500, 500);
        TGPoint startPoint = new TGPoint (0, 0);
        BallBot ballBot = new BallBot(ballWorld, startPoint, 0, 25);
        while(1 > 0) {
            if (ballBot.canMoveForward(ballWorld)){
                ballBot.moveForward();
            }else {
                ballBot.setHeading((ballBot.getHeading()+120)%360);
            }
        }
    }
}