package Serializers;

public interface Serializer<T>
{
    String serialize(T t);
    T deserialize(String data);
}
