package com.purasoft.richeditor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.purasoft.texteditor.RichEditor;

import petrov.kristiyan.colorpicker.ColorPicker;

public class MainActivity extends AppCompatActivity {

    private static final String BOLD = "<b>Bold</b><br><br>";
    private static final String ITALIT = "<i>Italic</i><br><br>";
    private static final String UNDERLINE = "<u>Underline</u><br><br>";
    private static final String STRIKETHROUGH = "<s>Strikethrough</s><br><br>"; // <s> or <strike> or <del>
    private static final String BULLET = "<ul><li>asdfg</li></ul>";
    private static final String EXAMPLE = BOLD + ITALIT + UNDERLINE + STRIKETHROUGH + BULLET;

    private RichEditor richEditor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        richEditor = findViewById(R.id.myrichtext);

        richEditor.fromHtml(EXAMPLE);
        richEditor.setSelection(richEditor.getEditableText().length());

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
                richEditor.bold(!richEditor.contains(RichEditor.FORMAT_BOLD));
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
                richEditor.italic(!richEditor.contains(RichEditor.FORMAT_ITALIC));
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
                richEditor.underline(!richEditor.contains(RichEditor.FORMAT_UNDERLINED));
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
                richEditor.strikethrough(!richEditor.contains(RichEditor.FORMAT_STRIKETHROUGH));
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
                richEditor.bullet(!richEditor.contains(RichEditor.FORMAT_BULLET));
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
                richEditor.clearFormats();
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

    private void colorPicker(final boolean isFromBgColor) {
        ColorPicker colorPicker = new ColorPicker(MainActivity.this);
        colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
            @Override
            public void onChooseColor(int position, int color) {
                if (isFromBgColor) {
                    richEditor.changeBgColor(color);
                } else {
                    richEditor.changeTextColor(color);
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
            case R.id.text_import:
                richEditor.fromHtml(getString(R.string.import_text));
                break;
            case R.id.export:
                String toHtml = Html.toHtml(richEditor.getText());
                Toast.makeText(MainActivity.this, toHtml, Toast.LENGTH_LONG).show();
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
