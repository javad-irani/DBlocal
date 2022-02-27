package com.jnt.newdbs.SecureData;

import com.jnt.newdbs.Models.PositionModel;

public interface InterfaceCostumeData {

    public PositionModel[][] EnCode(PositionModel[][] Array2D);
    public PositionModel[][] DeCode(PositionModel[][] Array2D);
}
