package ru.molokoin;

import java.util.List;

public class ControllerWishlist {
    private List<CoverPosition> positions;
    private FramePositions frame;//

    public ControllerWishlist(List<CoverPosition> positions){
        this.positions = positions;
        frame = new FramePositions(this.positions);
    }
}
