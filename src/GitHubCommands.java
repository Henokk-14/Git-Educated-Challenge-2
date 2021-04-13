package src;
import git.tools.client.GitSubprocessClient;

public class GitHubCommands {

  public GitHubCommands(){ }
  public static void main(String[] args){
     GitHubCommands run =  new GitHubCommands();
  }

  public String GitStatus(GitSubprocessClient Client, String repoString){
    try {
      System.out.println(repoString + " repoString");
    String stat  = Client.gitStatus();
    return stat;
    } catch (RuntimeException e){
     return "You have entered the wrong repo please try again:)";
    }
  }
  public String GitAdd(GitSubprocessClient gitSubprocessClient1,String filename) {
    try {
    String gitAddFile = gitSubprocessClient1.gitAddFile(filename);
    System.out.println(gitAddFile);
    if(gitAddFile.contains("fatal")){
    return  gitAddFile;
    } else
      return  "File: "+ filename+ " added";
    } catch (Exception e) {
      e.printStackTrace();
      return "Error file name entered incorrect file: "+ filename + " Doesn't exist in scope" ;
    }
  }

  public String Commit(GitSubprocessClient gitSubprocessClient, String CommitMsg){
    try{
      String commit = gitSubprocessClient.gitCommit(CommitMsg);
      return commit;
    } catch (Exception e) {
      return "ERROR your commit message was not accepted try again";
    }
  }

  public String Push(GitSubprocessClient gitSubprocessClient, String BranchName){
    try{
      String push = gitSubprocessClient.gitPush(BranchName);
      return push;
    } catch (Exception e) {
      return "ERROR your push was not successfully please try again";
    }
  }
}
