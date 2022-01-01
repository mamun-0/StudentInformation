package com.example.studentinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentinformation.adapter.DBAdapter;
import com.example.studentinformation.model.Student;

public class MainActivity extends AppCompatActivity {
    EditText name, ID, mobile, email, district, bloodGroup;
    DBAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editName);
        ID = findViewById(R.id.editID);
        mobile = findViewById(R.id.editPhoneNumber);
        email = findViewById(R.id.editEmail);
        district = findViewById(R.id.editDistrict);
        bloodGroup = findViewById(R.id.editBlood);
        adapter = new DBAdapter(this);
    }

    public void saveData(View view) {
        boolean flag = false;
        String sName = name.getText().toString();
        if (sName.isEmpty()) {
            flag = true;
            name.setError("Name required!");
        } else if (sName.length() < 4) {
            name.setError("Name must be grater than 4");
            flag = true;
        } else {
            flag = false;
        }


        String sID = ID.getText().toString();
        if (sID.isEmpty()) {
            ID.setError("ID required!");
            flag = true;
        } else {
            flag = false;
        }

        String sMobile = mobile.getText().toString();
        if (sMobile.isEmpty()) {
            mobile.setError("Required mobile number!");
            flag = true;
        } else if (sMobile.length() == 11 &&
                (sMobile.startsWith("017") ||
                        sMobile.startsWith("019") ||
                        sMobile.startsWith("016") ||
                        sMobile.startsWith("018") ||
                        sMobile.startsWith("013"))) {
            flag = false;
        } else {
            mobile.setError("Invalid Mobile Number!");
            flag = true;
        }


        String sEmail = email.getText().toString();
        if (sEmail.isEmpty()) {
            email.setError("Email required!");
            flag = true;
        } else if (!sEmail.contains("@")) {
            email.setError("Not include @");
            flag = true;
        } else {
            flag = false;
        }

        String sDistrict = district.getText().toString();
        if (sDistrict.isEmpty()) {
            district.setError("District required!");
            flag = true;

        } else {
            flag = false;
        }

        String sBloodGroup = bloodGroup.getText().toString();
        if (sBloodGroup.isEmpty()) {
            bloodGroup.setError("Blood group required");
            flag = true;
        } else if (sBloodGroup.equals("A+") ||
                sBloodGroup.equals("A-") ||
                sBloodGroup.equals("AB+") ||
                sBloodGroup.equals("AB-") ||
                sBloodGroup.equals("O+") ||
                sBloodGroup.equals("O-") ||
                sBloodGroup.equals("B+") ||
                sBloodGroup.equals("B-")
        ) {
            flag = false;
        } else {
            bloodGroup.setError("Invalid Blood Group");
            flag = true;
        }


        if(flag){
            Toast.makeText(getApplicationContext(), "Invalid Information. Try Again!", Toast.LENGTH_SHORT).show();
        }else {
            Student std = new Student(sName,sID,sMobile,sEmail,sDistrict,sBloodGroup);
            adapter.insertIntoDB(std);
            Toast.makeText(getApplicationContext(), "Successfully stored. ", Toast.LENGTH_SHORT).show();
        }

    }

    public void detailsData(View view) {
    }
}