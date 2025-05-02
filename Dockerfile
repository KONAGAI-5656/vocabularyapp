# --- ビルド用ステージ ---
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# 必要ファイルを個別に明示的にコピー
COPY pom.xml ./
COPY mvnw ./
COPY .mvn .mvn

# その他のプロジェクト全体をコピー
COPY src ./src

# Maven Wrapperに実行権限を与える
RUN chmod +x mvnw

# テストをスキップしてビルド
RUN ./mvnw clean package -DskipTests

# --- 実行用ステージ ---
FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY --from=builder /app/target/vocabularyapp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
