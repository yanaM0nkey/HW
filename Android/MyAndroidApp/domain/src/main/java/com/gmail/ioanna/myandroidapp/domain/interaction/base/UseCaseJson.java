package com.gmail.ioanna.myandroidapp.domain.interaction.base;


import java.util.ArrayList;

public interface UseCaseJson<InParam, OutParam> {
    ArrayList<OutParam> execute(InParam param);
}


