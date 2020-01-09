# RichTextEditor-Android
============

[![Jitpack.io](https://jitpack.io/v/rakesh2gnit/richtexteditorandroid.svg)](https://jitpack.io/#rakesh2gnit/richtexteditorandroid)

This is custom text editor which has features to make a text as Bold, Italic, Underline, Strike, Bullet, Change Text Color, Change Background Color etc.

Just select text and use one line code to style it!

Support Android 5.0+

## layout

<com.purasoft.texteditor.RichEditor
        android:id="@+id/myrichtext"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_alignParentTop="true"
        android:layout_above="@id/tools"
        android:paddingTop="16dp"
        android:paddingLeft="16dp"
        android:paddingStart="16dp"
        android:paddingRight="16dp"
        android:paddingEnd="16dp"
        android:gravity="top|start"
        android:scrollbars="vertical"
        android:background="@android:color/transparent"
        app:bulletColor="@color/blue_500"
        app:bulletRadius="@dimen/bullet_radius"
        app:bulletGapWidth="@dimen/bullet_gap_width"
        app:historyEnable="true"
        app:historySize="99">
    </com.purasoft.texteditor.RichEditor>
    
If you do not want to edit the text then add below two lines in layout:

        android:editable="false"
        tools:ignore="Deprecated"
        
To remove default copy/paste option on long press add below code in java class:

    editor.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                //to keep the text selection capability available ( selection cursor)
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                //to prevent the menu from appearing
                menu.clear();
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

## Api

 - `bold(boolean valid)` __bold__ the selected text.
 
 - `italic(boolean valid)` _italic_ the selected text.
 
 - `underline(boolean valid)` \<u>underline\</u> the selected text.
 
 - `strikethrough(boolean valid)` <s>strikethrough</s> the selected text. 
 
 - `bullet(boolean valid)` bullet the selected text.
 
 - `text color(int color)` change the color of the selected text.
 
 - `background color(int color)` change the background color of selected text.
 
 - `contains(int FORMAT)` return `true` if the selected text contains the FORMAT.
 
 - `clearFormats()` clear all formats. 
 
 - `redo()` when text changed, you can redo it!
 
 - `undo()` when text change, you can also undo it!
 
 - `fromHtml()` import from HTML file. 
 
 - `toHtml()` export as HTML file.
 
If you want to get more control of the editable text, just extend RichEditor to get all protected method.

#### Custom

 - `app:bulletColor`
 
 - `app:bulletRadius`
    
 - `app:bulletGapWidth`
 
 - `app:historyEnable` `true` to enable record history, so you can `redo()` and `undo()`.
    
 - `app:historySize` the record max limit.
 
## Gradle

At your top-level `build.gradle` file:

    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
    
And then at your project `build.gradle` file:

    dependencies {
        implementation 'com.github.rakesh2gnit:richtexteditorandroid:1.0.1'
    }
    
Done!

## Thanks

 - [Mthli](https://github.com/mthli/Knife)
 
## License

    Copyright 2020 Rakesh Kumar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
