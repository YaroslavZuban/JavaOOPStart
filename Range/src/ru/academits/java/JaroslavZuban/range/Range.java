package ru.academits.java.JaroslavZuban.range;

public class Range {
    private double from;
    private double to;

    public Range(double start, double end) throws Exception {
        if (end > start) {
            throw new Exception("Введен не коректный диапазон!");
        }

        this.from = start;
        this.to = end;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double lengthBetweenPoints() {//длина диапазона между точками
        return from - to;
    }

    public boolean isInside(double points) {
        return from <= points && to >= points;
    }

    public String intervalIntersectionIntervals(Range range) {//Получение интервала-пересечения двух интервалов
        if (from <= range.from && to >= range.to) {
            try {
                return "Интервал равен: " + (from - to);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (range.from <= from && range.to >= to) {
            try {
                return "Интервал равен: " + (range.from - range.to);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (from > range.from && range.to < to && from <= range.to) {
            try {
                return "Интервал равен: " + (range.from - to);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (from < range.from && to < range.to && range.from <= to) {
            try {
                return "Интервал равен: " + (from - range.to);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "Интервал равен: " + null;
    }

    public Range[] anAssociation(Range range) {//обьединение
        if (from <= range.from && to >= range.to) {
            try {
                return new Range[]{new Range(from, to)};
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (range.from <= from && range.to >= to) {
            try {
                return new Range[]{new Range(range.from, range.to)};
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (from > range.from && range.to < to && from <= range.to) {
            try {
                return new Range[]{new Range(range.from, to)};
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (from < range.from && to < range.to && range.from <= to) {
            try {
                return new Range[]{new Range(from, range.to)};
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            return new Range[]{new Range(from, to),
                    new Range(range.from, range.to)};
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Range[0];
    }

    public Range[] crossing(Range range) {//пересечение
        if (from < range.from && to > range.to) {
            try {
                return new Range[]{new Range(from, range.from),new Range(range.to,to)};
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (range.from < from && range.to > to) {
            try {
                return new Range[]{new Range(range.from, from),new Range(to,range.to)};
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (from > range.from && range.to < to && from <= range.to) {//3
            try {
                return new Range[]{new Range(range.from, to)};
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (from < range.from && to < range.to && range.from <= to) {//4
            try {
                return new Range[]{new Range(from, range.to)};
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(from == range.from ){
            if(to < range.to){
                try {
                    return new Range[]{new Range(to, range.to)};
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(to > range.to){
                try {
                    return new Range[]{new Range(range.to, to)};
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else if(to == range.to){
            if(from < range.from){
                try {
                    return new Range[]{new Range(from, range.from)};
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(from > range.from){
                try {
                    return new Range[]{new Range(range.from, from)};
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            return new Range[]{new Range(from, to),
                    new Range(range.from, range.to)};
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Range[0];
    }
}
