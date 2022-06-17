package java17;

public class SwitchExpression {

    enum SingleUsePlastic {
        CUP, STRAW, BOTTLE, COVER
    }

    int getDamageToPlanet(SingleUsePlastic plastic) {
        int damage = -1;
        switch (plastic) {
            case CUP:
                damage = 100;
                break;
            case STRAW:
                damage = 200;
                break;
            case BOTTLE:
                damage = 300;
                break;
        }
        return damage;
    }

    int getDamageToPlanet2(SingleUsePlastic plastic) {
        int damage = switch (plastic) {
            case CUP, COVER -> 100;
            case STRAW -> 200;
            case BOTTLE -> 300;
            default ->  1000;
        };
        return damage;
    }

}
