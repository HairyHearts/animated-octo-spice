package org.hairyhearts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.baasbox.android.BaasHandler;
import com.baasbox.android.BaasResult;
import com.baasbox.android.BaasUser;
import com.baasbox.android.json.JsonObject;

public class SuccessActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_success);

        findViewById(R.id.sendBtn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String to = ((EditText) findViewById(R.id.to)).getText().toString();
        String msg = ((EditText) findViewById(R.id.message)).getText().toString();

        BaasUser.withUserName(to).send(new JsonObject().putString("message", msg), new BaasHandler<Void>() {
            @Override
            public void handle(BaasResult<Void> voidBaasResult) {
                Log.d("RESULT: ", voidBaasResult.toString());

                Toast.makeText(SuccessActivity.this, "SENT MESSAGE", Toast.LENGTH_LONG).show();
            }
        });
    }

    // private void sendMessage() {
    // BaasUser.withUserName("ooooo").send(new JsonObject().putString("message",
    // "ciao"), new BaasHandler<Void>() {
    // @Override
    // public void handle(BaasResult<Void> voidBaasResult) {
    // Log.d("RESULT: ", voidBaasResult.toString() );
    //
    // Toast.makeText(SuccessActivity.this, "SENT MESSAGE",
    // Toast.LENGTH_LONG).show();
    // }
    // });
    // }
}
