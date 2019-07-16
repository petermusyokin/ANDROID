
package peter.example.androidintent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secondactivity extends AppCompatActivity {

    Button mBtndial,mBtncall,mBtnsms,mBtncamera,mBtnemail,mBtnshare,mBtnmpesa,mBtnhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        mBtndial= findViewById(R.id.btndial);
        mBtncall= findViewById(R.id.btncall);
        mBtnsms = findViewById(R.id.btntext);
        mBtncamera = findViewById(R.id.btncamera);
        mBtnemail = findViewById(R.id.btnemail);
        mBtnshare = findViewById(R.id.btnsharing);
        mBtnmpesa = findViewById(R.id.btnpesa);
        mBtnhome = findViewById(R.id.btnhome);

     mBtndial.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             String phone = "";
             Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
             startActivity(intent);





         }
     });
     mBtncall.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+9185118992660"));
             if (ContextCompat.checkSelfPermission(secondactivity.this,
                     Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                 ActivityCompat.requestPermissions(secondactivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
             }
             else
             {
                 startActivity(intent);
             }



         }
     });
     mBtncamera.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
             startActivityForResult(takePictureIntent, 1);

         }
     });
        mBtnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:0767585348");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "Niaje msee");
                startActivity(intent);

            }
        });
        mBtnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

            }
        });
        mBtnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome =new Intent(secondactivity.this,MainActivity.class);
                startActivity(gohome);

            }
        });
        mBtnmpesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent simToolKitLaunchIntent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
                if(simToolKitLaunchIntent != null) {
                    startActivity(simToolKitLaunchIntent);
                }

            }
        });
        mBtnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey, download this app!");
                startActivity(shareIntent);

            }
        });
    }
}
