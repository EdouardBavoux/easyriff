/*Copyright 2017 Edouard Bavoux

This file is part of EasyRif.

        EasyRif is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        EasyRif is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with EasyRif.  If not, see <http://www.gnu.org/licenses/>.*/

package com.eb.zoom.easyrif;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Edouard on 29/07/2017.
 */


public class dialogueNameTab extends DialogFragment{

    protected TextView nameTab = null;
    public onNameIsCommittedlistener nameCom;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Creation of the pop up dialog
        Log.d("dialog", "we're inside !");
        final View v = inflater.inflate(R.layout.boitedianame, container, false);

        //Handle the Validation of the new tab, with edited name
        Button validName = (Button) v.findViewById(R.id.validName);
        nameTab = (EditText) v.findViewById(R.id.nameTab);
        validName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Action to perform when validating the name of the tab
                Log.d("dialog", "Name is: "+ nameTab.getText() );
                nameCom.onNameIsCommitted((String) nameTab.getText().toString());
                dismiss();
            }
        });
        return v ;
    }

    //Definition of the function to be defined in the mainActivity, to react after the name is confirmed.

    public interface onNameIsCommittedlistener{
        public void onNameIsCommitted(String name);
    }
}