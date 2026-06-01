const fs = rerquire('fs');

fs.readdir('./', (err, files) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log(files);
});
