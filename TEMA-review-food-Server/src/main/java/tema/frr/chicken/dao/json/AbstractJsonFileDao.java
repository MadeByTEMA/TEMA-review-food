package tema.frr.chicken.dao.json;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public abstract class AbstractJsonFileDao<T> {

  protected String filename;
  protected List<T> list;


  public AbstractJsonFileDao(String filename) {
    this.filename = filename;
    list = new ArrayList<>();
    loadData();
  }

  @SuppressWarnings("unchecked")
  File file = new File(filename);

  @SuppressWarnings({"unchecked", "rawtypes"})
  protected void loadData() {
    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      Class<?> currType = this.getClass();
      Type parentType = currType.getGenericSuperclass();
      ParameterizedType parentType2 = (ParameterizedType) parentType;
      Type[] typeParams = parentType2.getActualTypeArguments();
      Type type = typeParams[0];
      T[] arr = (T[]) Array.newInstance((Class) type, 0);
      T[] dataArr = (T[]) new Gson().fromJson(in, arr.getClass());
      for (T b : dataArr) {
        list.add(b);
      }
      System.out.printf("총 %d 개의 객체를 로딩했습니다.\n", list.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
      e.printStackTrace();
    }
  }

  protected void saveData() {
    File file = new File(filename);

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.reset();
      out.writeObject(list);

      System.out.printf("총 %d 개의 수업 데이터를 저장했습니다.\n", list.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  protected abstract <K> int indexOf(K key);
}


