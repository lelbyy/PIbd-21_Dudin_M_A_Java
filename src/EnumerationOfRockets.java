public enum EnumerationOfRockets {

    Two,
    Four,
    Six;
    public static EnumerationOfRockets getChosenNumber(int number) {
        switch (number) {
            case 0:
                return EnumerationOfRockets.Two;
            case 1:
                return EnumerationOfRockets.Four;
            case 2:
                return EnumerationOfRockets.Six;
        }
        return null;
    }
}
