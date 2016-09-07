
/**
 * @Laurel Woods 
 * @activity 1
 */
public class BallRunner
{
    public  static void run() {
        BallWorld ballWorld = new BallWorld(500, 500);
        TGPoint startPoint = new TGPoint (0, 0);
        BallBot ballBot = new BallBot(ballWorld, startPoint, 0, 25);
        
        while(ballBot.canMoveForward(ballWorld)) {
            if (ballBot.canMoveForward(ballWorld)){
                ballBot.moveForward();
            }else {
                ballBot.setHeading(
        }
      
    }
}
