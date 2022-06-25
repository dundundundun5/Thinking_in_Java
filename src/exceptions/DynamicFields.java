package exceptions;

class DynamicFieldsException extends Exception {}

public class DynamicFields {
    //成对的对象，表示 字段标识符/字段值
    private Object[][] fields;
    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[] { null, null};
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (id.equals(fields[i][0]))
                return i;
        }
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNumber = hasField(id);
        if (fieldNumber == -1)
            throw new NoSuchFieldException();
        return fieldNumber;
    }

    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        //No empty fields.Add one
        Object[][] tmp = new Object[fields.length + 1][2];
        for (int j = 0; j < fields.length; j++)
            tmp[j] = fields[j];
        for (int j = fields.length; j < tmp.length; j++)
            tmp[j] = new Object[] {null, null};
        fields = tmp;
        //Recursive call with expanded fields:
        return makeField(id);
    }

    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id, Object value) throws DynamicFieldsException {
        //字段值为空则抛出异常
        if (value == null) {
            //Most exceptions don't have a "cause" constructor
            //In these cases you must use initCause()
            //available in all Throwable subclasses
            DynamicFieldsException dfe = new DynamicFieldsException();
            //dfe是通过initCase()方法把NullPointerException对象插入而建立的
            dfe.initCause(new NullPointerException());
            throw dfe;
        }

        int fieldNumber = hasField(id);
        if (fieldNumber == -1)
            fieldNumber = makeField(id);//没有该字段则创建一个新的字段
        Object result = null;
        try {
            result = getField(id); // get old value获取旧的字段值
        } catch (NoSuchFieldException e) {
            //Use constructor that takes "cause"
            throw new RuntimeException(e);
        }
        //修改已有的字段
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try {
            df.setField("d", "A value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);
            df.setField("d", "A new value for d");
            df.setField("number3", 11);
            System.out.println("df: " + df);
            System.out.println("df.getField(\"d\") : " + df.getField("d"));
            Object field = df.setField("d", null);//Exception
        } catch (NoSuchFieldException e) {
            e.printStackTrace(System.out);
        } catch (DynamicFieldsException e) {
            e.printStackTrace(System.out);
        }
    }
}
