
/**
 * @Laurel Woods 
 * @activity 2
 */
public class BallRunner
{
    private BallWorld ballWorld;
    private TGPoint entrancePoint;
    private BallBot[] ballBotArray;
    private ballBotArray;
    
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
        BallWorld ballWorld = new BallWorld(300, 300);
        TGPoint entrancePoint = new TGPoint (0, 0);
        int ballBotArrayLength = 10;
        BallRunner ball = new BallRunner(ballWorld, entrancePoint, ballBotArrayLength);
        while (1 > 0) {
            int freeBallBotIndex = ball.findFreeBallBotIndex();
            if (freeBallBotIndex < ballBotArrayLength) {
                BallBot ballBot = new BallBot(ballWorld, entrancePoint, (int)(Math.random()*360),10);
                ballBotArray[freeBallBotIndex] = ballBot;
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
