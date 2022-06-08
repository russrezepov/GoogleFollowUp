
import java.util.HashMap;
import java.util.Map;

public class Ayas {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int enteredToChangeValue = 1;

        hm.put(1, 100);
        hm.put(2, 200);
        hm.put(3, 100);

        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getKey() == enteredToChangeValue && entry.getValue() < enteredToChangeValue) {
                hm.put(entry.getKey(), enteredToChangeValue);
            }
        }
    }
}


/*
activity_first.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="15dp"
    tools:context="com.androidexample.First"
    android:orientation="vertical">

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/textBox"
        android:hint="Enter Your Message"/>

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/passButton"
        android:text="Pass"/>
</LinearLayout>

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="15dp"
    tools:context="com.androidexample.First"
    android:orientation="vertical">

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/textBox"
        android:hint="Enter Your Message"/>

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/passButton"
        android:text="Pass"/>
</LinearLayout>


activity_second.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="15dp"
    tools:context="com.androidexample.Second">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text=""
        android:id="@+id/text"/>
</LinearLayout>

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="15dp"
    tools:context="com.androidexample.Second">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text=""
        android:id"@+id/text"
</LinearLayout>


First.java

public class First extends AppCompatActivity {
    EditText textBox;
    Button passButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        textBox = (EditText)findViewById(R.id.textBox);
        passButton = (Button)findViewById(R.id.passButton);

        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textBox.getText().toString();

                Intent intent = new Intent(getApplicationContext(), Second.class);
                intent.putExtra("message", str);

                startActivity(intent);
            }
        });
    }
}


Second.java

public class Second extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text = (TextView)findViewById(R.id.text);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        text.setText(str);
    }
}



 */

