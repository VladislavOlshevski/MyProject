package sample.Animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shacke {
    private TranslateTransition tt;

    public Shacke(Node node) {
        tt = new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(0f);
        tt.setFromY(0f);
        tt.setByX(10f);
        tt.setByY(10f);
        tt.setCycleCount(10);
        tt.setAutoReverse(true);

    }

    public void playAnim() {
        tt.playFromStart();
    }
}
