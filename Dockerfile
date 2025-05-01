# --- ビルド用ステージ ---
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Maven Wrapper とソースコードをコピー
COPY . .

# テストをスキップしてビルド
RUN ./mvnw clean package -DskipTests

# --- 実行用ステージ ---
FROM eclipse-temurin:21-jdk

WORKDIR /app

# ビルド成果物をコピー（ファイル名は適宜変えて）
COPY --from=builder /app/target/vocabularyapp-0.0.1-SNAPSHOT.jar app.jar
COPY --from=builder /app/.env .env


# ポート指定（Spring Bootのデフォルト）
EXPOSE 8080

# Spring Boot アプリの起動
ENTRYPOINT ["java", "-jar", "app.jar"]
