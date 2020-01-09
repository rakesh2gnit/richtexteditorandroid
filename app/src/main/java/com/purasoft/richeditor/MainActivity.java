package com.purasoft.richeditor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.purasoft.texteditor.MyRichEditText;

import petrov.kristiyan.colorpicker.ColorPicker;

public class MainActivity extends AppCompatActivity {

    private static final String BOLD = "<b>Bold</b><br><br>";
    private static final String ITALIT = "<i>Italic</i><br><br>";
    private static final String UNDERLINE = "<u>Underline</u><br><br>";
    private static final String STRIKETHROUGH = "<s>Strikethrough</s><br><br>"; // <s> or <strike> or <del>
    private static final String BULLET = "<ul><li>asdfg</li></ul>";
    private static final String EXAMPLE = BOLD + ITALIT + UNDERLINE + STRIKETHROUGH + BULLET;

    private MyRichEditText myRichEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRichEditText = findViewById(R.id.myrichtext);

        myRichEditText.fromHtml(EXAMPLE);
        myRichEditText.setSelection(myRichEditText.getEditableText().length());

        setupBold();
        setupItalic();
        setupUnderline();
        setupStrikethrough();
        setupBullet();
        setupTextColorChange();
        setupBgColorChange();
        setupClear();
    }

    private void setupBold() {
        ImageButton bold = findViewById(R.id.bold);

        bold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRichEditText.bold(!myRichEditText.contains(MyRichEditText.FORMAT_BOLD));
            }
        });

        bold.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, R.string.toast_bold, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void setupItalic() {
        ImageButton italic = findViewById(R.id.italic);

        italic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRichEditText.italic(!myRichEditText.contains(MyRichEditText.FORMAT_ITALIC));
            }
        });

        italic.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, R.string.toast_italic, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void setupUnderline() {
        ImageButton underline = findViewById(R.id.underline);

        underline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRichEditText.underline(!myRichEditText.contains(MyRichEditText.FORMAT_UNDERLINED));
            }
        });

        underline.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, R.string.toast_underline, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void setupStrikethrough() {
        ImageButton strikethrough = findViewById(R.id.strikethrough);

        strikethrough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRichEditText.strikethrough(!myRichEditText.contains(MyRichEditText.FORMAT_STRIKETHROUGH));
            }
        });

        strikethrough.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, R.string.toast_strikethrough, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void setupBullet() {
        ImageButton bullet = findViewById(R.id.bullet);

        bullet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRichEditText.bullet(!myRichEditText.contains(MyRichEditText.FORMAT_BULLET));
            }
        });


        bullet.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, R.string.toast_bullet, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void setupTextColorChange() {
        ImageButton textColor = findViewById(R.id.txtcolor);

        textColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorPicker(false);
            }
        });

        textColor.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, R.string.toast_text_color, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void setupBgColorChange() {
        ImageButton bgcolor = findViewById(R.id.bgcolor);

        bgcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorPicker(true);
            }
        });

        bgcolor.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, R.string.toast_bg_color, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void setupClear() {
        ImageButton clear = findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRichEditText.clearFormats();
            }
        });

        clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, R.string.toast_format_clear, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void colorPicker(final boolean isFromBgColor){
        ColorPicker colorPicker = new ColorPicker(MainActivity.this);
        colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
            @Override
            public void onChooseColor(int position, int color) {
                if(isFromBgColor) {
                    myRichEditText.changeBgColor(false, color);
                }else{
                    myRichEditText.changeTextColor(true, color);
                }
            }

            @Override
            public void onCancel() {
                // put code
            }
        }).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.undo:
                myRichEditText.undo();
                break;
            case R.id.redo:
                myRichEditText.redo();
                break;
            case R.id.github:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.app_repo)));
                startActivity(intent);
                break;
            default:
                break;
        }

        return true;
    }
}
