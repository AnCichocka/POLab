package agh.ics.oop;

enum MapDirection{
    NORTH,
    SOUTH,
    WEST,
    EAST;

    @Override
    public String toString(){

        String message = switch(this){
            case NORTH -> "północ";
            case WEST -> "zachód";
            case SOUTH -> "południe";
            case EAST -> "wschód";
        };

        return message;
    }

    public MapDirection next(){

        MapDirection nextMapDirection = switch(this){
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };

        return nextMapDirection;
    }

    public MapDirection previous(){

        MapDirection previousMapDirection = switch(this){
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
        };

        return previousMapDirection;
    }

    public Vector2d toUnitVector(){

        Vector2d unitVector = switch(this){
            case NORTH -> new Vector2d(0,1);
            case WEST -> new Vector2d(-1,0);
            case SOUTH -> new Vector2d(0,-1);
            case EAST -> new Vector2d(1,0);
        };

        return unitVector;
    }


}

