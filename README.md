# RichTextEditor-Android
============

[![Jitpack.io](https://jitpack.io/v/rakesh2gnit/richtexteditorandroid.svg)](https://jitpack.io/#rakesh2gnit/richtexteditorandroid)

This is custom text editor which has features to make a text as Bold, Italic, Underline, Strike, Bullet, Change Text Color, Change Background Color etc.

Just select text and use one line code to style it!

Support Android 5.0+

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
 
If you want to get more control of the editable text, just extend MyRichEditText to get all protected method.

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
        implementation 'com.github.rakesh2gnit:richtexteditorandroid:1.0.0'
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
