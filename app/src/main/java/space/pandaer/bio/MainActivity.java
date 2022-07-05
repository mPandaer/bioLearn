package space.pandaer.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import space.pandaer.bio.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.btDone.setOnClickListener(this::showHobbies);

    }

    public void showHobbies(View view) {
        binding.textHobbies.setText(
                String.format("Hobbies: %s ",binding.etEnterHobbies.getText().toString())
        );
        binding.invalidateAll();
        binding.textHobbies.setVisibility(View.VISIBLE);
        //hide keyboard
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}