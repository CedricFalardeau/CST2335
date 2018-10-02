package com.example.cedri.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends Activity {
    final ArrayList<String> chatList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        Button sendButton = (Button) this.findViewById(R.id.send);
        final EditText chat = (EditText) this.findViewById(R.id.chatText);
        ListView listView = (ListView) this.findViewById(R.id.listView);
        final ChatAdapter messageAdapter =new ChatAdapter( this );
        listView.setAdapter (messageAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatList.add(chat.getText().toString());
                messageAdapter.notifyDataSetChanged();
                chat.setText("");
            }
        });
    }
    private class ChatAdapter extends ArrayAdapter<String>{
        public ChatAdapter(Context ctx) {
            super(ctx, 0);}

        public int getCount (){
            return (chatList.size());
        }
        public String getItem(int position){
            return chatList.get(position);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null ;
            if(position%2 == 0)
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            else
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            TextView message = (TextView)result.findViewById(R.id.message_text);
            message.setText( getItem(position) ); // get the string at position
            return result;
        }
        public long getItemId(int position){
            return position;
        }
    }
}
