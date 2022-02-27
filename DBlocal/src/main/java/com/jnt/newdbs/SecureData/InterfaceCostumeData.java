package com.jnt.newdbs.SecureData;

import com.jnt.newdbs.Models.PositionModel;

public interface InterfaceCostumeData {

    PositionModel[][] EnCode(PositionModel[][] Array2D);
    PositionModel[][] DeCode(PositionModel[][] Array2D);
}
