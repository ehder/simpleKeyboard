package com.solt.d_keyboard;

import android.content.Context;
import android.graphics.Outline;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckBox;

public class SimpleIME extends InputMethodService implements KeyboardView.OnKeyboardActionListener  {

    private boolean caplock;
    private KeyboardView keyboardView;
    private Keyboard engKeyboard;
    private Keyboard engNum1;
    private Keyboard engNum2;
    private Keyboard kayinKeyboard1;
    private Keyboard kayinKeyboard2;
    private Keyboard kayinNum1;
    private Keyboard unicode1;
    private Keyboard unicode2;
    private Keyboard unicodeNum1;
    private Vibrator vibrator;

    public void getKeyBoard() {
        engKeyboard = new Keyboard(this, R.xml.eng_layout);
        engNum1 = new Keyboard(this, R.xml.eng_num1);
        engNum2 = new Keyboard(this, R.xml.eng_num2);
        kayinKeyboard1 = new Keyboard(this, R.xml.kayin_layout1);
        kayinKeyboard2 = new Keyboard(this, R.xml.kayin_layout2);
        kayinNum1 = new Keyboard(this, R.xml.kayin_num1);
        unicode1 = new Keyboard(this, R.xml.unicode_layout1);
        unicode2 = new Keyboard(this, R.xml.unicode_layout2);
        unicodeNum1 = new Keyboard(this, R.xml.unicode_num1);
    }

    public void vibrate(){
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(vibrator.hasVibrator()){
            vibrator.vibrate(80);
        }
    }

    public void vibrateOn(){
        System.out.println("**************(((((((((((");
    }



    @Override
    public View onCreateInputView() {
        getKeyBoard();
        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.simple_input, null);
        keyboardView.setKeyboard(engKeyboard);
        keyboardView.setPreviewEnabled(false);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override
    public void onInitializeInterface() {
        super.onInitializeInterface();
    }

    @Override
    public void onStartInputView(EditorInfo info, boolean restarting) {
        super.onStartInputView(info, restarting);
    }

    @Override
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        super.onStartInput(attribute, restarting);
    }

    @Override
    public void onPress(int primaryCode) {
        vibrate();
    }

    @Override
    public void onRelease(int primaryCode) {

    }



    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection connection = getCurrentInputConnection();
        if (connection != null) {
            switch (primaryCode) {
                case Keyboard.KEYCODE_SHIFT:
                    caplock = !caplock;
                    engKeyboard.setShifted(caplock);
                    keyboardView.invalidateAllKeys();
                    break;
                case Keyboard.KEYCODE_DELETE:
                    connection.deleteSurroundingText(1, 0);
                    break;
                case Keyboard.KEYCODE_DONE:
                    sendKeyChar('\n');
                    break;
                case -50:
                    keyboardView.setKeyboard(engNum1);
                    break;
                case -51:
                    keyboardView.setKeyboard(engKeyboard);
                    break;
                case -52:
                    keyboardView.setKeyboard(engNum2);
                    break;
                case -53:
                    keyboardView.setKeyboard(kayinKeyboard1);
                    break;
                case -10:
                    keyboardView.setKeyboard(kayinKeyboard2);
                    break;
                case -54:
                    keyboardView.setKeyboard(kayinNum1);
                    break;
                case -40:
                    keyboardView.setKeyboard(unicode1);
                    break;
                case -100:
                    keyboardView.setKeyboard(unicode2);
                    break;

                case -80:
                    sendKeyChar('မ');
                    sendKeyChar('်');
                    break;
                case -81:
                    sendKeyChar('ဧ');
                    sendKeyChar('ၢ');
                    break;
                case -82:
                    sendKeyChar('ၢ');
                    sendKeyChar('်');
                    break;
                case -83:
                    sendKeyChar('ၣ');
                    sendKeyChar('်');
                    break;
                case -84:
                    sendKeyChar('ၥ');
                    sendKeyChar('်');
                    break;
                case -85:
                    sendKeyChar('ဒ');
                    sendKeyChar('်');
                    break;
                case -86:
                    sendKeyChar('လ');
                    sendKeyChar('ီ');
                    sendKeyChar('ၤ');
                    break;
                case -87:
                    sendKeyChar('၎');
                    sendKeyChar('င');
                    sendKeyChar('်');
                    sendKeyChar('း');
                    break;
                case -88:
                    sendKeyChar('ဒ');
                    sendKeyChar('်');
                    break;
                case -89:
                    sendKeyChar('လ');
                    sendKeyChar('ၢ');
                    break;
                case -90:
                    sendKeyChar('န');
                    sendKeyChar('ၤ');
                    break;
                case -91:
                    sendKeyChar('ယ');
                    sendKeyChar('ၤ');
                    break;
                case -92:
                    sendKeyChar('မ');
                    sendKeyChar('့');
                    sendKeyChar('ၢ');
                    sendKeyChar('်');
                    break;
                case -93:
                    sendKeyChar('ဧ');
                    sendKeyChar('ါ');
                    break;
                case -94:
                    sendKeyChar('ဒ');
                    sendKeyChar('ီ');
                    sendKeyChar('း');
                    break;

                default:
                    char code = (char) primaryCode;
                    if (caplock) {
                        code = Character.toUpperCase(code);
                    }
                    connection.commitText(String.valueOf(code), 1);
            }
        }


    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }

    public class getshodaw extends ViewOutlineProvider{

        @Override
        public void getOutline(View view, Outline outline) {

        }
    }
}
