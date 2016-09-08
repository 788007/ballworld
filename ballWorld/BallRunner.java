
/**
 * @Laurel Woods 
 * @activity 1
 */
public class BallRunner
{
    BallWorld ballWorld;
    TGPoint entrancePoint;
    BallBot[] ballBotArray;
    
    public BallRunner(BallWorld ballWorld, TGPoint entrancePoint, int ballBotArrayLength){
        
        BallBot[] ballBotArray = new BallBot[ballBotArrayLength - 1];
    }
    
    public int findFreeBallBotIndex() {
        for (int i = 0; i < ballBotArray.length; i ++) {
            if (ballBotArray[i] == null) {
                return i;
            } 
            
        }
        return ballBotArray.length;
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
