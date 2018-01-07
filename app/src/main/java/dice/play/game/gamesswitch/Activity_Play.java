package dice.play.game.gamesswitch;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Animatable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by said BAHAOUARY on 05/03/17.
 */

public class Activity_Play extends Activity {



    public void dialog_show(){

        AlertDialog.Builder alertadd = new AlertDialog.Builder(Activity_Play.this);

        LayoutInflater factory = LayoutInflater.from(Activity_Play.this);

        final View view = factory.inflate(dice.play.game.gamesswitch.R.layout.dialoglayout, null);

        RelativeLayout contentView = (RelativeLayout) ((Activity) this)
                .getLayoutInflater().inflate(dice.play.game.gamesswitch.R.layout.dialoglayout, null);

        alertadd.setView(contentView);

        final ImageView image = (ImageView) contentView.findViewById(dice.play.game.gamesswitch.R.id.dialog_imageview);
        ((Animatable) image.getDrawable()).start();

        alertadd.setNeutralButton(dice.play.game.gamesswitch.R.string.showDice, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dlg, int sumthin) {


                ImageView myImageRandom = (ImageView) findViewById(dice.play.game.gamesswitch.R.id.imgDice);

                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), dice.play.game.gamesswitch.R.raw.dice);

                Double random =Math.random()*6;
                Integer intRandom = random.intValue();

                switch (intRandom){
                    case  0:
                        myImageRandom.setImageResource(dice.play.game.gamesswitch.R.drawable.dice1);
                        mediaPlayer.start();
                        break;
                    case  1:
                        myImageRandom.setImageResource(dice.play.game.gamesswitch.R.drawable.dice2);
                        mediaPlayer.start();
                        break;
                    case  2:
                        myImageRandom.setImageResource(dice.play.game.gamesswitch.R.drawable.dice3);
                        mediaPlayer.start();

                        break;
                    case  3:
                        myImageRandom.setImageResource(dice.play.game.gamesswitch.R.drawable.dice4);
                        mediaPlayer.start();

                        break;
                    case  4:
                        myImageRandom.setImageResource(dice.play.game.gamesswitch.R.drawable.dice5);
                        mediaPlayer.start();
                        break;
                    case  5:
                        myImageRandom.setImageResource(dice.play.game.gamesswitch.R.drawable.dice6);
                        mediaPlayer.start();
                        break;
                }
            }
        });
        alertadd.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(dice.play.game.gamesswitch.R.layout.activity_play);

        this.setFinishOnTouchOutside(false);

        ImageView myImageRandom = (ImageView) findViewById(dice.play.game.gamesswitch.R.id.imgDice);

        myImageRandom.setImageResource(dice.play.game.gamesswitch.R.drawable.defaultdice);

        final ImageButton buttonRandom = (ImageButton) findViewById(dice.play.game.gamesswitch.R.id.btndice);

        buttonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt = (TextView) findViewById(dice.play.game.gamesswitch.R.id.myTextImageButton);
                txt.setText(dice.play.game.gamesswitch.R.string.tryagain);
                MediaPlayer mp = MediaPlayer.create(getBaseContext(), dice.play.game.gamesswitch.R.raw.buttonclick2);
                mp.start();
                dialog_show();
            }
        });
    }


}
